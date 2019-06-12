package com.duan.app.controller.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @ClassName:CustomDateConverter.java
 * @Description:自定义日期转换器
 * @author duan
 * @Time 2019年5月22日上午10:02:29
 * 
 */

public class CustomDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
	try {
	    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

}
