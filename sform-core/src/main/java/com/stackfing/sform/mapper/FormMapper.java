package com.stackfing.sform.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Author: fing
 * @Description:
 * @Date: 2019/7/26
 * @Since:
 */
public interface FormMapper {

    String selectFormByName(@Param("formname") String formname);

}