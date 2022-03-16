package com.controller;

import com.constant.MessageConstant;
import com.constant.RedisMessageConstant;
import com.entity.Result;
import com.utils.SMSUtils;
import com.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {
    @Autowired
    private JedisPool jedisPool;
    @RequestMapping("send4Order")
    public Result send4Order(String telephone) {
        //生成4位验证码
        Integer code = ValidateCodeUtils.generateValidateCode(4);
        try {
            SMSUtils.main(telephone,code.toString());
            System.out.println("发送的手机验证码为：" + code);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        //验证码存redis
        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_ORDER, 5 *60, code.toString());

        //发送成功
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);

    }

}
