package com.hamob.data.entity;

import java.io.Serializable;

public class IndexImage implements Serializable {
    private String id;
    private String captureTime;
    private String proto;
    private String ip;
    private int port;
    private String url;
    private String host;
    private String request;
    private String referer;
    private int fileSize;
    private String fileName;
    private String filterReason;
    private int eroticism;
    private int phishingSimilarity;
    private String picId;
    private int phishing;
    private String phishingPicId;

    public IndexImage() {
    }

    public IndexImage(String id, String captureTime, String proto, String ip, int port, String url, String host,
                      String request, String referer, int fileSize, String fileName, String filterReason, int eroticism,
                      int phishingSimilarity, String picId, int phishing, String phishingPicId) {
        this.id = id;
        this.captureTime = captureTime;
        this.proto = proto;
        this.ip = ip;
        this.port = port;
        this.url = url;
        this.host = host;
        this.request = request;
        this.referer = referer;
        this.fileSize = fileSize;
        this.fileName = fileName;
        this.filterReason = filterReason;
        this.eroticism = eroticism;
        this.phishingSimilarity = phishingSimilarity;
        this.picId = picId;
        this.phishing = phishing;
        this.phishingPicId = phishingPicId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(String captureTime) {
        this.captureTime = captureTime;
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilterReason() {
        return filterReason;
    }

    public void setFilterReason(String filterReason) {
        this.filterReason = filterReason;
    }

    public int getEroticism() {
        return eroticism;
    }

    public void setEroticism(int eroticism) {
        this.eroticism = eroticism;
    }

    public int getPhishingSimilarity() {
        return phishingSimilarity;
    }

    public void setPhishingSimilarity(int phishingSimilarity) {
        this.phishingSimilarity = phishingSimilarity;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public int getPhishing() {
        return phishing;
    }

    public void setPhishing(int phishing) {
        this.phishing = phishing;
    }

    public String getPhishingPicId() {
        return phishingPicId;
    }

    public void setPhishingPicId(String phishingPicId) {
        this.phishingPicId = phishingPicId;
    }

    @Override
    public String toString() {
        return "IndexImage{" +
                "id='" + id + '\'' +
                ", captureTime='" + captureTime + '\'' +
                ", proto='" + proto + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", url='" + url + '\'' +
                ", host='" + host + '\'' +
                ", request='" + request + '\'' +
                ", referer='" + referer + '\'' +
                ", fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", filterReason='" + filterReason + '\'' +
                ", eroticism=" + eroticism +
                ", phishingSimilarity=" + phishingSimilarity +
                ", picId='" + picId + '\'' +
                ", phishing=" + phishing +
                ", phishingPicId='" + phishingPicId + '\'' +
                '}';
    }
}
