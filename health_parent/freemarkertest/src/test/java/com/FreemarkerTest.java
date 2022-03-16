package com;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerTest {
    @Test
    public void test01() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        //设置目录不是设置文件
        configuration.setDirectoryForTemplateLoading(new File("H:\\12"));
        configuration.setDefaultEncoding("utf-8");
        Template template = configuration.getTemplate("123.ftl");
        //利用map来给ftl文件中的数据进行赋值构造
        Map map = new HashMap();
        map.put("name", "张三");
        map.put("message", "hello world");
        Writer writer = new FileWriter(new File("H:\\12\\hello.html"));
        template.process(map,writer);
        writer.close();

    }
    }
