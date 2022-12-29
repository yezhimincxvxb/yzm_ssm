package com.yzm2.plugin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Page<E> implements Serializable {
    private static final long serialVersionUID = -8093992033805880632L;
    private int start;
    private int nowPage;
    private int pageShow;
    private int totalPage;
    private int totalCount;
    private List<E> result = Collections.emptyList();

    public int getNowPage() {
        if (nowPage < 2)
            nowPage = 1;
        if (nowPage > getTotalPage())
            nowPage = getTotalPage();
        return nowPage;
    }

    public int getPageShow() {
        if (pageShow < 2) return 1;
        return pageShow;
    }

    public int getStart() {
        return (getNowPage() - 1) * getPageShow();
    }

    public int getTotalPage() {
        return (int) Math.ceil(totalCount * 1.0 / getPageShow());
    }
}