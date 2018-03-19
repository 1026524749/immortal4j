package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/8 9:34
 */
@Entity(name = "t_sys_user")
public class SysUser extends BaseEntity {
    /**
     * 登陆帐户
     */
    @Column(name = "account_")
    private String account;

    /**
     * 密码
     */
    @Column(name = "password_")
    private String password;
    /**
     * 用户类型(1普通用户2管理员3系统用户)
     */
    @Column(name = "user_type")
    private String userType;
    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 姓名拼音
     */
    @Column(name = "name_pinyin")
    private String namePinyin;
    /**
     * 性别(0:未知;1:男;2:女)
     */
    @Column(name = "sex_")
    private Integer sex;
    /**
     * 头像
     */
    @Column(name = "avatar_")
    private String avatar;
    /**
     * 电话
     */
    @Column(name = "phone_")
    private String phone;
    /**
     * 邮箱
     */
    @Column(name = "email_")
    private String email;
    /**
     * 身份证号码
     */
    @Column(name = "id_card")
    private String idCard;
    /**
     * 微信
     */
    @Column(name = "wei_xin")
    private String weiXin;
    /**
     * 微博
     */
    @Column(name = "wei_bo")
    private String weiBo;
    /**
     * QQ
     */
    @Column(name = "qq_")
    private String qq;
    /**
     * 出生日期
     */
    @Column(name = "birth_day")
    private Date birthDay;
    /**
     * 部门编号
     */
    @Column(name = "dept_id")
    private Long deptId;
    /**
     * 职位
     */
    @Column(name = "position_")
    private String position;
    /**
     * 详细地址
     */
    @Column(name = "address_")
    private String address;
    /**
     * 工号
     */
    @Column(name = "staff_no")
    private String staffNo;

    @Transient
    private String oldPassword;
    @Transient
    private String deptName;
    @Transient
    private String userTypeText;
    @Transient
    private String permission;
}
