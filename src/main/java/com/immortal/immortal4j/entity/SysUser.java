package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/8 9:34
 */
@Entity(name = "t_sys_user")
@Where(clause = " enable_=1")
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getWeiXin() {
        return weiXin;
    }

    public void setWeiXin(String weiXin) {
        this.weiXin = weiXin;
    }

    public String getWeiBo() {
        return weiBo;
    }

    public void setWeiBo(String weiBo) {
        this.weiBo = weiBo;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUserTypeText() {
        return userTypeText;
    }

    public void setUserTypeText(String userTypeText) {
        this.userTypeText = userTypeText;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
