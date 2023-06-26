package com.yuki.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "yuki")
public class YukiProperty {
    private String name;

    private String authors;

    private String version;

    private String fileRootPath;

    private String captchaType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFileRootPath() {
        return fileRootPath;
    }

    public void setFileRootPath(String fileRootPath) {
        this.fileRootPath = fileRootPath;
    }

    public String getCaptchaType() {
        return captchaType;
    }

    public void setCaptchaType(String captchaType) {
        this.captchaType = captchaType;
    }


    /**
     * 获取导入上传路径
     */
    public String getImportPath()
    {
        return getFileRootPath() + "/import/";
    }

    /**
     * 获取头像上传路径
     */
    public String getAvatarPath()
    {
        return getFileRootPath() + "/avatar/";
    }

    /**
     * 获取下载路径
     */
    public String getDownloadPath()
    {
        return getFileRootPath() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public String getUploadPath()
    {
        return getFileRootPath() + "/upload/";
    }
}
