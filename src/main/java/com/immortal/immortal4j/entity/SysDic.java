package com.immortal.immortal4j.entity;

import com.immortal.immortal4j.base.BaseEntity;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/10 20:53
 */
@Entity
@Where(clause = " enable_=1")
public class SysDic extends BaseEntity {
    @Column(name = "type_")
    private String type;
    @Column(name = "code_")
    private String code;
    private String codeText;
    private Integer sortNo;
    @Column(name = "editable_")
    private Boolean editable;
    @Column(name = "parent_type")
    private String parentType;
    @Column(name = "parent_code")
    private String parentCode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeText() {
        return codeText;
    }

    public void setCodeText(String codeText) {
        this.codeText = codeText;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
