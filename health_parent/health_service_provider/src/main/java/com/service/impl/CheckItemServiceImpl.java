package com.service.impl;

import com.dao.CheckItemDao;
import com.alibaba.dubbo.config.annotation.Service;
import com.entity.PageResult;
import com.entity.QueryPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pojo.CheckItem;
import com.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
* 检查项服务
* */
@Service(interfaceClass = CheckItemService.class)//因为要暴露服务，所以要使用dubbo的注解,如果加了事务功能，这里就必须明确接口类
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage, pageSize);
        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);
        System.out.println(page+"-------------------------------");
        long total = page.getTotal();
        List<CheckItem> rows = page.getResult();
        return new PageResult(total, rows);
    }

    @Override
    public Boolean deleteById(Integer id) {
        //判断检查项是否有关联
        Long count = checkItemDao.findCountByCheckItemId(id);
        if(count !=null){
            new RuntimeException("检查项有关联");

        }
        checkItemDao.deleteById(id);
        return true;
    }

    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    @Override
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
