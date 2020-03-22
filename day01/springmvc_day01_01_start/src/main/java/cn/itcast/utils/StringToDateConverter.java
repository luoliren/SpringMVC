package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换成日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     * String s 传入字符串的值
     * @param s
     * @return
     */
    @Override
    public Date convert(String s) {
        //判断
        if (s == null) {
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df =new SimpleDateFormat("yyyy-MM-dd");

        try {
            //把字符串转化成日期
            Date date =df.parse(s);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转化出现错误");
        }
    }
}
