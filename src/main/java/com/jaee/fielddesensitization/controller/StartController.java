package com.jaee.fielddesensitization.controller;

import com.bnyte.forge.annotation.APIHelper;
import com.bnyte.forge.http.reactive.web.R;
import com.jaee.fielddesensitization.bind.EnableFieldEncryption;
import com.jaee.fielddesensitization.vo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author bnyte
 * @date 2022/4/15 1:03
 * @mail bnytezz@gmail.com
 */
@RestController
@RequestMapping("/start")
public class StartController {

    /**
     * 不加密，请求地址：localhost:8080/start/original
     * @return 响应结果
     */
    @APIHelper // 这个不重要，这是我的日志框架注解
    @PostMapping("/original")
    R<User> original() {
        return R.ok(User.getInstance());
    }

    /**
     * 加密，请求地址：localhost:8080/start/encryption
     * @return 响应结果
     */
    @APIHelper
    @EnableFieldEncryption // 开启加密
    @PostMapping("/encryption")
    R<User> encryption() {
//        throw new RuntimeException("111"); // 试全局异常 打开它
        return R.ok(User.getInstance());
    }

}
