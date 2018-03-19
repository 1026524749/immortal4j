package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/9 16:50
 */
@Entity
public class SysMsgConfig extends BaseEntity {
    /**
     * 短信平台地址
     */
    @Column(name = "sms_plat_url")
    private String smsPlatUrl;
    /**
     * 短信平台帐号
     */
    @Column(name = "sms_plat_account")
    private String smsPlatAccount;
    /**
     * 短信平台密码
     */
    @Column(name = "sms_plat_password")
    private String smsPlatPassword;
    /**
     * 发送短信签名
     */
    @Column(name = "sender_name")
    private String senderName;
    /**
     * 客户下订单时是否给商家发短信
     */
    @Column(name = "order_is_send")
    private Integer orderIsSend;
    /**
     * 客户付款时是否给商家发短信
     */
    @Column(name = "pay_is_send")
    private Integer payIsSend;
    /**
     * 商家发货时是否给客户发短信
     */
    @Column(name = "send_goods_is_send")
    private Integer sendGoodsIsSend;
    /**
     * 用户注册时是否给客户发短信
     */
    @Column(name = "regist_is_send")
    private Integer registIsSend;
    /**
     * 用户付款后是否给客户发收货验证码
     */
    @Column(name = "advice_goods_is_send")
    private Integer adviceGoodsIsSend;
}
