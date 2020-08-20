package com.hamob.data.service;

import com.hamob.data.entity.IndexImage;
import com.hamob.data.entity.IndexText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadIndexFile {

    private static Logger logger = LogManager.getLogger(ReadIndexFile.class);

    public static List<IndexText> readTextFile(String indexDir){
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;

        List<IndexText> indexList = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(indexDir);
            inputStreamReader= new InputStreamReader(fileInputStream,"UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String txt;
            while (( txt=bufferedReader.readLine()) != null && !"" .equals(txt)){
                String[] texts = txt.split("\t");
                IndexText indexText = new IndexText();
                if (!"".equals(texts[0])){
                    indexText.setDeviceId(texts[0]);
                }
                if (!"".equals(texts[1])){
                    indexText.setCapturetime(texts[1]);
                }
                if (!"".equals(texts[2])){
                    indexText.setProto(texts[2]);
                }
                if (!"".equals(texts[3])){
                    indexText.setIp(texts[3]);
                }
                if (!"".equals(texts[4])){
                    indexText.setPort(Integer.valueOf(texts[4]));
                }
                if (!"".equals(texts[5])){
                    indexText.setUrl(texts[5]);
                }
                if (!"".equals(texts[6])){
                    indexText.setHost(texts[6]);
                }
                if (!"".equals(texts[7])){
                    indexText.setRequest(texts[7]);
                }
                if (!"".equals(texts[8])){
                    indexText.setEncoding(texts[8]);
                }
                if (!"".equals(texts[9])){
                    indexText.setCharset(texts[9]);
                }
                if (!"".equals(texts[10])){
                    indexText.setReferer(texts[10]);
                }
                if (!"".equals(texts[11])){
                    indexText.setFilesize(Long.valueOf(texts[11]));
                }
                if (!"".equals(texts[12])){
                    indexText.setFilename(texts[12]);
                }
                if (!"".equals(texts[13])){
                    indexText.setFilterreason(Integer.valueOf(texts[13]));
                }
                if (!"".equals(texts[14])){
                    indexText.setFilterscore(Integer.valueOf(texts[14]));
                }
                if (!"".equals(texts[15])){
                    indexText.setPhishing_filterscore(Integer.valueOf(texts[15]));
                }
                if (!"".equals(texts[16])){
                    indexText.setKeywords_sex(texts[16]);
                }
                if (!"".equals(texts[17])){
                    indexText.setPhishing(Integer.valueOf(texts[17]));
                }
                if (!"".equals(texts[18])){
                    indexText.setKeywords_phishing_url(texts[18]);
                }
                if (!"".equals(texts[19])){
                    indexText.setKeywords_phishing(texts[19]);
                }

                indexList.add(indexText);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return indexList;
    }


    public static List<IndexImage> readImageFile(String indexDir){
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;

        List<IndexImage> indexList = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream(indexDir);
            inputStreamReader= new InputStreamReader(fileInputStream,"UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String pic;
            while (( pic=bufferedReader.readLine()) != null && !"" .equals(pic)){
                String[] texts = pic.split("\t");
                IndexImage indexImage = new IndexImage();
                if (!"".equals(texts[0])){
                    indexImage.setId(texts[0]);
                }
                if (!"".equals(texts[1])){
                    indexImage.setCaptureTime(texts[1]);
                }
                if (!"".equals(texts[2])){
                    indexImage.setProto(texts[2]);
                }
                if (!"".equals(texts[3])){
                    indexImage.setIp(texts[3]);
                }
                if (!"".equals(texts[4])){
                    indexImage.setPort(Integer.valueOf(texts[4]));
                }
                if (!"".equals(texts[5])){
                    indexImage.setUrl(texts[5]);
                }
                if (!"".equals(texts[6])){
                    indexImage.setHost(texts[6]);
                }
                if (!"".equals(texts[7])){
                    indexImage.setRequest(texts[7]);
                }
                if (!"".equals(texts[8])){
                    indexImage.setReferer(texts[8]);
                }

                if (!"".equals(texts[9])){
                    indexImage.setFileSize(Integer.valueOf(texts[9]));
                }
                if (!"".equals(texts[10])){
                    indexImage.setFileName(texts[10]);
                }
                if (!"".equals(texts[11])){
                    indexImage.setFilterReason(texts[11]);
                }
                if (!"".equals(texts[12])){
                    indexImage.setEroticism(Integer.parseInt(texts[12]));
                }
                if (!"".equals(texts[13])){
                    indexImage.setPhishingSimilarity(Integer.valueOf(texts[13]));
                }
                if (!"".equals(texts[14])){
                    indexImage.setPicId(texts[14]);
                }
                if (!"".equals(texts[15])){
                    indexImage.setPhishing(Integer.parseInt(texts[15]));
                }
                if (!"".equals(texts[16])){
                    indexImage.setPhishingPicId(texts[16]);
                }

                indexList.add(indexImage);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return indexList;
    }
}
