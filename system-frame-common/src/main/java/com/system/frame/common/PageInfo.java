package com.system.frame.common;

import lombok.Data;

import java.util.List;


@Data
public class PageInfo {

    private Integer successcode = 200;

    private String msg = "请求成功";

    private List rows;

    private long total;

}
