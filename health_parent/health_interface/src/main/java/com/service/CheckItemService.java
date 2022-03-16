package com.service;

import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.pojo.CheckItem;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface CheckItemService {
    public void add(CheckItem checkItem);
    public PageResult pageQuery(QueryPageBean queryPageBean);
    public Boolean deleteById(Integer id);
    public void edit(CheckItem checkItem);
    public CheckItem findById(Integer id);
    public List<CheckItem> findAll();
}
