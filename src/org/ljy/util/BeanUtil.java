package org.ljy.util;

import com.github.pagehelper.Page;
import org.ljy.common.PagedResult;

import java.util.List;

/**
 * Created by ljy56 on 2017/5/6.
 */
public class BeanUtil {
    public static PagedResult toPagedResult(List<?> datas) {
        PagedResult result = new PagedResult();
        if (datas instanceof Page) {
            Page page = (Page) datas;
            result.setPageNo(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setDataList(page.getResult());
            result.setTotal(page.getTotal());
            result.setPages(page.getPages());
        }
        else {
            result.setPageNo(1);
            result.setPageSize(datas.size());
            result.setDataList(datas);
            result.setTotal(datas.size());
        }
        return result;
    }
}
