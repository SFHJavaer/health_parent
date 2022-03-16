package com.service;

import com.entity.PageResult;
import com.pojo.CheckGroup;
import com.pojo.Setmeal;
import java.util.List;
/**
 * 体检套餐服务接口
 */
public interface SetmealService {
    public void add(Setmeal setmeal, Integer[] checkgroupIds);
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);
    public List<Setmeal> findAll();
    public Setmeal findById(int id);
}