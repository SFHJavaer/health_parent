package com.dao;

import com.github.pagehelper.Page;
import com.pojo.CheckItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckItemDao {
    public void add(CheckItem checkItem);
    public Page<CheckItem> selectByCondition(String queryString);
    //使用PageHelper<>来传回一组数据而不是一个checkItem
    public Boolean deleteById(Integer id);
    public Long findCountByCheckItemId(Integer id);
    public void edit(CheckItem checkItem);
    public List<CheckItem> findAll();
    public CheckItem findById(Integer id);
}
