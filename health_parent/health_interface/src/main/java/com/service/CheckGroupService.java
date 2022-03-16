package com.service;

import com.entity.PageResult;
import com.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {
    void add(CheckGroup checkGroup, Integer[] checkitemIds);
    void setCheckGroupAndCheckItem(Integer checkGroupId,Integer[] checkitemIds);
    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
    CheckGroup findById(Integer id);
    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    public void edit(CheckGroup checkGroup,Integer[] checkitemIds);
    List<CheckGroup> findAll();
}
