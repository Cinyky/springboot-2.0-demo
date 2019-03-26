package com.cyy.springdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 项目名称：HengYuLogger
 * 项目版本：V1.0
 * 包名称：com.hengyu.logger.entity
 * 创建人：yuqy
 * 创建时间：2017/3/28 15:57
 * 修改人：yuqy
 * 修改时间：2017/3/28 15:57
 * 修改备注：
 */
@Entity
@Table(name = "t_logger_infos")
@Data
public class LoggerEntity implements Serializable
{
    //编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ali_id")
    private Long id;
    //客户端请求ip
    @Column(name = "ali_client_ip")
    private String clientIp;
    //客户端请求路径
    @Column(name = "ali_uri")
    private String uri;
    //终端请求方式,普通请求,ajax请求
    @Column(name = "ali_type")
    private String type;
    //请求方式method,post,get等
    @Column(name = "ali_method")
    private String method;
    //请求参数内容,json
    @Column(name = "ali_param_data")
    private String paramData;
    //请求接口唯一session标识
    @Column(name = "ali_session_id")
    private String sessionId;
    //请求时间
    @Column(name = "ali_time",insertable = false)
    private Timestamp time;
    //接口返回时间
    @Column(name = "ali_returm_time")
    private String returnTime;
    //接口返回数据json
    @Column(name = "ali_return_data")
    private String returnData;
    //请求时httpStatusCode代码，如：200,400,404等
    @Column(name = "ali_http_status_code")
    private String httpStatusCode;
    //请求耗时秒单位
    @Column(name = "ali_time_consuming")
    private int timeConsuming;


}
