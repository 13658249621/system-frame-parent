package com.system.frame.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fxbin
 * @create 2020-03-11 11:14
 * description:   分页对象工厂
 */
public class PageFactory {

    /**
     * 获取layui table的分页参数
     *
     * @author @Data
@Builder
@AllArgsConstructor
@NoArgsConstructorshuonan
     * @Date 2019/1/25 22:13
     */
    public static Page defaultPage() {
        HttpServletRequest request = HttpContext.getRequest();

        int limit = 20;
        int page = 1;

        //每页多少条数据
        String limitString = request.getParameter("limit");
        if (StringUtils.isNotBlank(limitString)) {
            limit = Integer.parseInt(limitString);
        }

        //第几页
        String pageString = request.getParameter("page");
        if (StringUtils.isNotEmpty(pageString)) {
            page = Integer.parseInt(pageString);
        }

        return new Page(page, limit);
    }

    /**
     * 创建layui能识别的分页响应参数
     *
     * @author fengshuonan
     * @Date 2019/1/25 22:14
     */
    public static PageInfo createPageInfo(IPage page) {
        PageInfo result = new PageInfo();
        result.setTotal(page.getTotal());
        result.setRows(page.getRecords());
        return result;
    }
}

