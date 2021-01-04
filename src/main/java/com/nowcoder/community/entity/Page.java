package com.nowcoder.community.entity;

/*
* 封装分页信息
*/
public class Page {
    //当前页
    private int current = 1;
    //每页条数
    private int limit = 10;
    //共多少条数
    private int rows;
    //查询每页跳转链接
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current > 0) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >= 1 && limit <= 50) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows > 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //获取当前页起始行
    public int getOffset() {
        // current * limit - limit
        return (current - 1) * limit + 1;
    }

    //获取总页数
    public int getTotal() {
        // rows / limit [+1]
        if(rows % limit == 0) {
            return rows / limit;
        }else {
            return rows / limit + 1;
        }
    }

    //获取当前页前2页
    public int getFrom() {
        int from = current - 3;
        return from < 1 ? 1 : from;
    }

    //获取当前页后2页
    public int getTo() {
        int to = current + 3;
        int total = getTotal();
        return to > total ? total : to;
    }
}
