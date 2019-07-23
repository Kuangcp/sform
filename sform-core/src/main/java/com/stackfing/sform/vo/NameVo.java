package com.stackfing.sform.vo;

import com.stackfing.sform.beans.annotation.BusniessField;
import com.stackfing.sform.beans.annotation.BusniessObject;

/**
 * @Author: fing
 * @Description:
 * @Date: 2019/7/23
 * @Since:
 */

@BusniessObject("用户")
public class NameVo {

    @BusniessField("用户名")
    private String name;

    @BusniessField("路径")
    private String path;

    @BusniessField("url")
    private String url;

}
