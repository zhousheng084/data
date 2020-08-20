package com.hamob.data.listener;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.concurrent.TimeUnit;


@RestController
@RefreshScope
public class FileListenerFactory {


    /*监听路径*/
    @Value("${montorDir}")
    private String montorDir;

    /*设置监听轮询间隔*/
    private final  long interval = TimeUnit.SECONDS.toMillis(1);

    /*自动注入业务服务*/
    @Autowired
    private ListenerService listenerService;

    public FileAlterationMonitor getMonitor(){
        //创建过滤器
        IOFileFilter directories = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(),
                HiddenFileFilter.VISIBLE);
        IOFileFilter files = FileFilterUtils.and(
                FileFilterUtils.suffixFileFilter(".zip"));
        IOFileFilter filter = FileFilterUtils.or(directories, files);

        //装配过滤器
        FileAlterationObserver observer = new FileAlterationObserver(new File(montorDir), filter);

        //向监听者添加监听器，并注入业务服务
        observer.addListener(new FileListener(listenerService));

        //返回监听者
        return new FileAlterationMonitor(interval,observer);
    }
}
