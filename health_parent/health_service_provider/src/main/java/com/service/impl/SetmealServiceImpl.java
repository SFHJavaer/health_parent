package com.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.constant.RedisConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.dao.SetmealDao;
import com.entity.PageResult;
import com.pojo.Setmeal;
import com.service.SetmealService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import redis.clients.jedis.JedisPool;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 体检套餐服务实现类
 */
@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealDao setmealDao;
    @Autowired
//    Autowired默认是按类型class注入
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Autowired
    private JedisPool jedisPool;
    @Value("${out_put_path}")//读取配置文件的参数
    private String outputpath;




    //新增套餐
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setmealDao.add(setmeal);
        if(checkgroupIds != null && checkgroupIds.length > 0){
            //绑定套餐和检查组的多对多关系
            setSetmealAndCheckGroup(setmeal.getId(),checkgroupIds);
        }
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES,setmeal.getImg());
        //新增套餐后需要重新生成static页面
        this.generateMobileStaticHtml();

    }


    //具体生成静态页面的方法
    public void generateMobileStaticHtml(){
        //准备模板中需要的数据
        List<Setmeal> setmealList = this.findAll();
        generateMobileSetmealListHtml(setmealList);
        generateMobileSetmealDetailhtml(setmealList);

    }

    private void generateMobileSetmealDetailhtml(List<Setmeal> setmealList) {

        for (Setmeal setmeal : setmealList) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("setmeal", this.findById(setmeal.getId()));

            //注意下面的htmlpagename，因为每一个套餐是对应一个具体的详情页面，而且套餐详情是从套餐列表页面的herf进入的，所以注意字符串的拼接和套餐列表遍历的href属性一致
            this.generateHtml("mobile_setmeal_detail.ftl",
                    "setmeal_detail_"+setmeal.getId()+".html",
                    dataMap);
        }
    }

    private void generateMobileSetmealListHtml(List<Setmeal> setmealList) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("setmealList", setmealList);
        this.generateHtml("mobile_setmeal.ftl","m_setmeal.html",dataMap);
    }
    //定义生成模板的具体方法(自定义参数，需要什么硬编码就传入什么)
    public void generateHtml(String templateName,String htmlPageName,Map<String,Object> datamap){
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Writer out = null;
        try {
            Template template = configuration.getTemplate(templateName);
            File docFile = new File(outputpath + "\\" + htmlPageName);
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            //输出文件
            template.process(datamap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                try {
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //绑定套餐和检查组的多对多关系
    private void setSetmealAndCheckGroup(Integer id, Integer[] checkgroupIds) {
        for (Integer checkgroupId : checkgroupIds) {
            Map<String,Integer> map = new HashMap<>();
            map.put("setmeal_id",id);
            map.put("checkgroup_id",checkgroupId);
            setmealDao.setSetmealAndCheckGroup(map);
        }
    }
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage,pageSize);

        Page<Setmeal> page = setmealDao.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }
    public List<Setmeal> findAll() {
        return setmealDao.findAll();
    }
    public Setmeal findById(int id) {
        return setmealDao.findById(id);
    }
    public List<Map<String, Object>> findSetmealCount() {
        return setmealDao.findSetmealCount();
    }
}
//Controller在所在的项目展示模块上创建，谁展示就在哪创