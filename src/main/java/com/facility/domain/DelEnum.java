package com.facility.domain;

/**
 * @Title: DelEnum
 * @Author Fcsummer
 * @Package com.facility.domain
 * @Date 2023/7/22 10:58
 * @description: 是否删除枚举类
 */
public enum DelEnum {

    DELETE(1),
    NOT_DELETE(2);
    private Integer delFlag;

    DelEnum(Integer delFlag){
        this.delFlag=delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }
}
