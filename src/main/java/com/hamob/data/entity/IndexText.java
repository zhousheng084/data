package com.hamob.data.entity;

public class IndexText {

    private String deviceId;

    private String capturetime;

    private String proto;

    private String ip;

    private int port;

    private String url;

    private String host;

    private String request;

    private String encoding;

    private String charset;

    private String referer;

    private long filesize;

    private String filename;

    private int filterreason;

    private int filterscore;

    private int phishing_filterscore;

    private String keywords_sex;

    private int phishing;

    private String keywords_phishing_url;

    private String keywords_phishing;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCapturetime() {
        return capturetime;
    }

    public void setCapturetime(String capturetime) {
        this.capturetime = capturetime;
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

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getFilterreason() {
        return filterreason;
    }

    public void setFilterreason(int filterreason) {
        this.filterreason = filterreason;
    }

    public int getFilterscore() {
        return filterscore;
    }

    public void setFilterscore(int filterscore) {
        this.filterscore = filterscore;
    }

    public int getPhishing_filterscore() {
        return phishing_filterscore;
    }

    public void setPhishing_filterscore(int phishing_filterscore) {
        this.phishing_filterscore = phishing_filterscore;
    }

    public String getKeywords_sex() {
        return keywords_sex;
    }

    public void setKeywords_sex(String keywords_sex) {
        this.keywords_sex = keywords_sex;
    }

    public int getPhishing() {
        return phishing;
    }

    public void setPhishing(int phishing) {
        this.phishing = phishing;
    }

    public String getKeywords_phishing_url() {
        return keywords_phishing_url;
    }

    public void setKeywords_phishing_url(String keywords_phishing_url) {
        this.keywords_phishing_url = keywords_phishing_url;
    }

    public String getKeywords_phishing() {
        return keywords_phishing;
    }

    public void setKeywords_phishing(String keywords_phishing) {
        this.keywords_phishing = keywords_phishing;
    }

    public IndexText() {
    }

    public IndexText(String deviceId, String capturetime, String proto, String ip, int port, String url, String host,
                     String request, String encoding, String charset, String referer, long filesize, String filename,
                     int filterreason, int filterscore, int phishing_filterscore, String keywords_sex, int phishing,
                     String keywords_phishing_url, String keywords_phishing) {
        this.deviceId = deviceId;
        this.capturetime = capturetime;
        this.proto = proto;
        this.ip = ip;
        this.port = port;
        this.url = url;
        this.host = host;
        this.request = request;
        this.encoding = encoding;
        this.charset = charset;
        this.referer = referer;
        this.filesize = filesize;
        this.filename = filename;
        this.filterreason = filterreason;
        this.filterscore = filterscore;
        this.phishing_filterscore = phishing_filterscore;
        this.keywords_sex = keywords_sex;
        this.phishing = phishing;
        this.keywords_phishing_url = keywords_phishing_url;
        this.keywords_phishing = keywords_phishing;
    }

    @Override
    public String toString() {
        return "IndexData{" +
                "deviceId='" + deviceId + '\'' +
                ", capturetime='" + capturetime + '\'' +
                ", proto='" + proto + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", url='" + url + '\'' +
                ", host='" + host + '\'' +
                ", request='" + request + '\'' +
                ", encoding='" + encoding + '\'' +
                ", charset='" + charset + '\'' +
                ", referer='" + referer + '\'' +
                ", filesize=" + filesize +
                ", filename='" + filename + '\'' +
                ", filterreason=" + filterreason +
                ", filterscore=" + filterscore +
                ", phishing_filterscore=" + phishing_filterscore +
                ", keywords_sex='" + keywords_sex + '\'' +
                ", phishing=" + phishing +
                ", keywords_phishing_url='" + keywords_phishing_url + '\'' +
                ", keywords_phishing='" + keywords_phishing + '\'' +
                '}';
    }
}
