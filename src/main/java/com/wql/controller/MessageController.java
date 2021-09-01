package com.wql.controller;


import com.wql.pojo.Messages;
import com.wql.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    @Qualifier("MessageServiceImpl")
    private MessageService messageService;

    @RequestMapping(value = "/allMessage")
    @ResponseBody
    public String queryAllMessage(){
        System.out.println("接收到请求");
        List<Messages> list=messageService.queryAllMessage();
//        String str=JSON.toJSONString(list);
//        System.out.println(str);
        System.out.println("转换完成");
        return "wql";
    }

    @RequestMapping(value = "/test")
    public String test(){
        Messages messages=new Messages();
        messages.setId(1);
        messages.setTime(new Date());
        messages.setName("wql");
        messages.setState("未认领");
        messages.setType(1);
        messageService.addMessage(messages);
        System.out.println("成功");
        return "test";
    }

}
