package com.stackfing.sform.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: fing
 * @Description:
 * @Date: 2019/7/26
 * @Since:
 */
public interface FormMapper {

    String selectFormByName(@Param("formname") String formname);

    List<String> selectAllForm();

    void updateFormByName(@Param("data") Map<Object, Object> data);

}
