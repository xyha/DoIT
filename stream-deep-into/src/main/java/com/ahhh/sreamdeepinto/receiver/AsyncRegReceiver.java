package com.ahhh.sreamdeepinto.receiver;

import com.ahhh.sreamdeepinto.channel.AsyncRegChannel;
import com.ahhh.sreamdeepinto.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

/**
 * @author ahhh
 * @title: RegReceiver
 * @projectName eureka-server
 * @description: 消息消费者，用来读取消息中间件中的消息
 * @date 2020/12/25
 */
@EnableBinding(AsyncRegChannel.class)
public class AsyncRegReceiver {

    //用来将 Thymeleaf 模版渲染成 HTML 页面
    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    MailService mailService;

    @StreamListener(AsyncRegChannel.INPUT)
    public void sendVerifyCode(Map<String, Object> map) {
        //发送验证邮件和短信
        System.out.println("receive:" + map);
        //先创建一个 Context 实例，这个实例中保存了我们即将渲染到 Thymeleaf 中的数据
        Context ctx = new Context();
        String email = (String) map.get("email");
        ctx.setVariable("email", email);
        ctx.setVariable("code", (int) (Math.random() * 10000));
        //调用 TemplateEngine 中的 process 方法，将 Thymeleaf 模版渲染成 HTML 页面
        String mail = templateEngine.process("mailtemplate.html", ctx);
        mailService.sendHtmlMail("764632525@qq.com",
                email,
                "欢迎注册XXX网站",
                mail);
    }
}
