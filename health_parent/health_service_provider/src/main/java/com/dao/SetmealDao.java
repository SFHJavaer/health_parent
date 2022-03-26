package com.dao;

import com.entity.PageResult;
import com.github.pagehelper.Page;
import com.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndCheckGroup(Map<String, Integer> map);
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
    public Page<Setmeal> selectByCondition(String queryString);
    public List<Setmeal> findAll();
    public Setmeal findById(int id);
    public List<Map<String,Object>> findSetmealCount();
}