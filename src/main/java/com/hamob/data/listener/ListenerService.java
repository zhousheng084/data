package com.hamob.data.listener;




import com.hamob.data.entity.IndexImage;
import com.hamob.data.entity.IndexText;
import com.hamob.data.service.MemcachedRunner;
import com.hamob.data.service.ReadIndexFile;
import com.hamob.data.service.ZipService;
import com.hamob.data.utils.DeleteFileUtil;
import com.hamob.data.utils.PicURLTransform;
import com.hamob.data.utils.ReadFile;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RefreshScope
public class ListenerService {

    private Logger logger = LogManager.getLogger(ListenerService.class);

    /*压缩文件目录*/
    @Value("${fileDir}")
    private String fileDir;

    @Resource
    MemcachedRunner memcachedRunner;

    @Autowired
    JdbcTemplate jdbcTemplate;

   public void method(){
       File file = new File(fileDir);
       String [] files = file.list();
       //获取缓存对象
       MemcachedClient client = memcachedRunner.getClient();
       client.getStats();
       if (files.length != 0) {
           for (int i = 0; i < files.length; i++) {
               if (files[i].endsWith(".zip")&&files[i].contains("TXT")) {
                   //压缩文件相对路径
                   String zipFilePath = fileDir + "/" + files[i];
                   String descPath = fileDir + "/" + files[i].split(".zip")[0];
                   //获取压缩文件，并解压
                   boolean flag = ZipService.uncompress(zipFilePath, descPath);
                   if (flag){
                       logger.info("解压TXT文件！");
                       //读取index文件
                        File txtfile = new File(descPath);
                        String[] f = txtfile.list();
                       if (f.length != 0){
                           for (int j = 0; j <f.length ; j++) {
                               if (f[j].contains("index")){
                                   //将index文件信息读取出来
                                   String indexDir = descPath+"/"+f[j];
                                   List<IndexText> indexList = ReadIndexFile.readTextFile(indexDir);
                                   //遍历indexList，将文本内容入缓存
                                   //调用memcacheClient
                                   for (IndexText data:indexList) {

                                        String filename = data.getFilename();
                                        String filePath = descPath+"/"+filename;
                                        String hashUrl = PicURLTransform.URL2ID(data.getUrl());
                                        hashUrl = String.format("%s.%s",hashUrl,"txt");
                                        File file2 = new File(filePath);
                                        //根据路径读取文本内容
                                       String text = ReadFile.getContent(file2);
                                       OperationFuture<Boolean> addStr = client.add(hashUrl, 0, text);

                                       try {

                                           if (addStr.get()){

                                               logger.info("成功添加到 memcached ");
                                               SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                                               String protolid = null;

                                               if("httpget".equals((data.getProto()+data.getRequest()))){
                                                    protolid ="0000";
                                               }
                                               if("httppost".equals(data.getProto()+data.getRequest())){
                                                   protolid ="0001";
                                               }

                                               String sql = "call TEXTDQ_TMP_IMPORT('"+data.getHost()+"'," +
                                                       "'"+data.getFilterreason()+"',"+
                                                       "'"+data.getCapturetime()+"',"+
                                                       "'"+data.getUrl()+"',"+
                                                      // "'"+data.getKeywords_sex()+"',"+
                                                       "'"+"目前用空字符串表示"+"',"+
                                                       "'"+1+"',"+//中标关键字类型
                                                       data.getFilesize()+","+
                                                       0+","+//...pv +
                                                       "'"+protolid+"',"+//PROTOCOLID  0000
                                                       "'text/html',"+
                                                       "'"+data.getReferer()+"',"+
                                                       "'"+data.getFilename()+"',"+
                                                       "'',"+//title
                                                     //  "'',"+//cookiefile 暂时不用
                                                       "'"+data.getDeviceId()+"',"+
                                                       "'',"+//关键字ID
                                                       data.getFilterscore()+","+
                                                       "'"+data.getIp()+"',"+
                                                       "'"+data.getPort()+"',"+
                                                       "'"+hashUrl+"',"+//本地路径
                                                       0+","+//crawlflag
                                                       0+","+//domainflag
                                                       data.getPhishing()+
                                               ")";

                                            logger.info(sql);

                                            jdbcTemplate.execute(sql);
                                            logger.info("Insert data successfully ");

                                           }
                                       } catch (InterruptedException e) {
                                           e.printStackTrace();
                                       } catch (ExecutionException e) {
                                           e.printStackTrace();
                                       }
                                   }

                               }
                           }

                       }
                       DeleteFileUtil.deleteDirectory(descPath);
                   }else{
                       logger.info("TXT解压缩失败！   path="+zipFilePath);
                   }
               }else if (files[i].endsWith(".zip")&&files[i].contains("PIC")){
                   //图片数据包处理
                   //压缩文件相对路径
                   String picPath = fileDir + "/" + files[i];
                   String descPath = fileDir + "/" + files[i].split(".zip")[0];
                   //获取压缩文件，并解压
                   boolean flag = ZipService.uncompress(picPath, descPath);
                   if (flag){
                       logger.info("解压PIC文件！");
                           //读取index文件
                           File picFile = new File(descPath);
                           String[] f = picFile.list();
                           if (f.length != 0){
                               for (int j = 0; j <f.length ; j++) {
                                   if (f[j].contains("index")){
                                       //将index文件信息读取出来
                                       String indexDir = descPath+"/"+f[j];
                                       List<IndexImage> indexList = ReadIndexFile.readImageFile(indexDir);
                                       //遍历indexList，将文本内容入缓存
                                       //调用memcacheClient
                                       for (IndexImage data:indexList) {

                                           String filename = data.getFileName();
                                           String filePath = descPath+"/"+filename;
                                           String hashUrl = PicURLTransform.URL2ID(data.getUrl());
                                           hashUrl = String.format("%s.%s",hashUrl,"jpg");

                                           try {
                                                //根据路径读取文本内容
                                                byte[] imageDate= ReadFile.readImage(filePath);
                                               OperationFuture<Boolean> addStr = client.add(hashUrl, 0, imageDate);
                                               if (addStr.get()){

                                                   logger.info("成功添加到 memcached ");
                                                   SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                                                   String protolid = null;

                                                   if("httpget".equals((data.getProto()+data.getRequest()))){
                                                       protolid ="0000";
                                                   }
                                                   if("httppost".equals(data.getProto()+data.getRequest())){
                                                       protolid ="0001";
                                                   }
                                                   /**
                                                    * fileType 是数据类型 1；图片  2：文本
                                                    */
                                                   int fileType = 0;
                                                   if (data.getFilterReason().equals("PIC")){
                                                       fileType =1;
                                                   }else {
                                                       fileType =2;
                                                   }

                                                   String sql = "call PICDQ_TMP_IMPORT('"
                                                           +data.getHost()+"',"
                                                           +fileType+",'"
                                                           +data.getIp()+"','"
                                                           +data.getUrl()+"','"
                                                           +data.getCaptureTime()+"',"
                                                           +data.getEroticism()+",'"
                                                           +data.getId()+"','"
                                                           +protolid+"',"
                                                           +data.getPort()+",'"
                                                           +data.getReferer()+"',"
                                                         //  +data.getpv+"," //访问量 1
                                                           +"1"+",'"
                                                           +"" +"','" //cookieflie 为空
                                                           +hashUrl+"','"
                                                           +data.getPicId()+"',"
                                                           +0+","   //crawlflag
                                                           +1+","   //域名类型
                                                           +data.getPhishing()+","
                                                           +100+","
                                                           +data.getPhishingPicId()+","
                                                           +data.getPhishingSimilarity()
                                                           +")";

                                                   logger.info(sql);

                                                   jdbcTemplate.execute(sql);
                                                   logger.info("Insert data successfully ");

                                               }
                                           } catch (InterruptedException e) {
                                               e.printStackTrace();
                                           } catch (ExecutionException e) {
                                               e.printStackTrace();
                                           }
                                       }

                                   }
                               }

                           }
                           //DeleteFileUtil.deleteDirectory(descPath);
                       }else{
                       logger.info("PIC解压缩失败！   path="+picPath);
                       }
                   DeleteFileUtil.deleteDirectory(descPath);
                   }
               }
       }else{
            logger.info("未找到压缩文件");
       }
   }

   public void delete(){

       logger.info("删除压缩文件");
   }




}
