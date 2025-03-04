package com.system.frame.config;/**
 * Created with IntelliJ IDEA.
 * @author: wjr
 * @Date: 2020/3/13
 * @Time: 10:40
 * 天下风云出我辈， 一入代码岁月催
 * 皇图霸业谈笑间， 不胜人生一场醉
 * 提剑跨骑挥鬼雨， 白骨如山鸟惊飞
 * 尘事如潮人如水， 只叹江湖几人回
 */

import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.apache.commons.lang3.StringUtils;

import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JSON形式的全局时间类型转换器
 */
public class CustomDateFormat extends StdDateFormat {

    private static final long serialVersionUID = -3201781773655300201L;

    public static final CustomDateFormat instance = new CustomDateFormat();

    @Override
    /**
     * 只要覆盖parse(String)这个方法即可
     */
    public Date parse(String dateStr, ParsePosition pos) {
        return getDate(dateStr, pos);
    }

    @Override
    public Date parse(String dateStr) {
        ParsePosition pos = new ParsePosition(0);
        return getDate(dateStr, pos);
    }

    private Date getDate(String dateStr, ParsePosition pos) {
        SimpleDateFormat sdf = null;
        if (StringUtils.isBlank(dateStr)) {
            return null;
        } else if (dateStr.matches("^\\d{4}-\\d{1,2}$")) {
            sdf = new SimpleDateFormat("yyyy-MM");
            return sdf.parse(dateStr, pos);
        } else if (dateStr.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr, pos);
        } else if (dateStr.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.parse(dateStr, pos);
        } else if (dateStr.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(dateStr, pos);
        } else if (dateStr.length() == 23) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            return sdf.parse(dateStr, pos);
        }
        return super.parse(dateStr, pos);
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date, toAppendTo, fieldPosition);
    }

    @Override
    public CustomDateFormat clone() {
        return new CustomDateFormat();
    }
}