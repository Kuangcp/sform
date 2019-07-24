package com.stackfing.sform.beans.enums;

import lombok.Getter;

/**
 * @Author: fing
 * @Description:
 * @Date: 2019/7/24
 * @Since:
 */
@Getter
public enum BoType {

    VO(1, "vo对象"),
    ENTITY(2, "实体对象")
    ;

    private String name;
    private int type;

    BoType(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
