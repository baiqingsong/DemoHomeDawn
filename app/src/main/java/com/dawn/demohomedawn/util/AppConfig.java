package com.dawn.demohomedawn.util;

import java.io.File;

/**
 * 描述：初始设置类.
 * Created by 90449 on 2017/5/23.
 */

public class AppConfig {

    /** UI设计的基准宽度. */
    public static int UI_WIDTH = 720;

    /** UI设计的基准高度. */
    public static int UI_HEIGHT = 1080;

    /** 默认 SharePreferences文件名. */
    public static String SHARED_PATH = "app_share";

    /** 默认下载文件地址. */
    public static String DOWNLOAD_ROOT_DIR = "Android" + File.separator + "data";

    /** 默认下载图片文件地址. */
    public static String DOWNLOAD_IMAGE_DIR = "images";

    /** 默认下载文件地址. */
    public static String DOWNLOAD_FILE_DIR = "files";

    /** APP缓存目录. */
    public static String CACHE_DIR = "caches";

    /** DB目录. */
    public static String DB_DIR = "db";
}
