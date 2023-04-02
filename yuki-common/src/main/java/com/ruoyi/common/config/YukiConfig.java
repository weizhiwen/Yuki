package com.ruoyi.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "yuki")
public class YukiConfig {
    private String name;

    private String authors;

    private String version;

    private static String fileRootPath;

    private static String captchaType;

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

    public static void setFileRootPath(String fileRootPath) {
        YukiConfig.fileRootPath = fileRootPath;
    }

    public static String getCaptchaType() {
        return captchaType;
    }

    public static void setCaptchaType(String captchaType) {
        YukiConfig.captchaType = captchaType;
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
