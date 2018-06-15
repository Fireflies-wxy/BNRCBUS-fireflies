package com.bnrc.bnrcbus.network;

/**
 * Created by apple on 2018/5/31.
 * @function: 所有请求相关地址
 */

public class HttpConstants {

    private static final String ROOT_URL = "http://47.95.205.147:8080";

    /**
     * 新版服务器地址
     */
    public static final String UPLOAD_URL = ROOT_URL + "/api/v1/update";// 上传实时数据
    public static final String lineWithOneStationURL = "http://47.95.205.147:8080/admin/station";// 请求本条线路上固定站点的最近一辆车
    public static final String lineWithAllStationURL = "http://47.95.205.147:8080/admin/line";// 请求本条线路上所有车次的信息
    public static final String VERSION_URL = ROOT_URL + "/api/v1/version";// 请求数据库版本号
    public static final String BEIJINGDB_URL = ROOT_URL + "/api/v1/download";// 更新数据库
    public static final String POSTCOLLECTMESSAGE_URL = ROOT_URL + "/api/v1/collect";

}
