package com.yuki.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "yuki")
public class YukiProperty {
    private String name;

    private String authors;

    private String version;

    private static String fileRootPath;

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

    public static String getFileRootPath() {
        return fileRootPath;
    }

    public void setFileRootPath(String fileRootPath) {
        YukiProperty.fileRootPath = fileRootPath;
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
    public static String getImportPath()
    {
        return getFileRootPath() + "/import/";
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath()
    {
        return getFileRootPath() + "/avatar/";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getFileRootPath() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getFileRootPath() + "/upload/";
    }
}
