package com.pyyexclusivenew.pyy.control;

import com.pyyexclusivenew.pyy.entity.Login;
import com.pyyexclusivenew.pyy.service.ILoginService;
import com.pyyexclusivenew.pyy.service.impl.LoginServiceImpl;
import com.pyyexclusivenew.pyy.util.base.BaseResponse;
import com.pyyexclusivenew.pyy.util.code.CodeEnum;
import com.sun.org.apache.bcel.internal.classfile.Code;
import javafx.beans.binding.ObjectBinding;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/administrator")
public class AdministratorController {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    /**
     * @Author ThorLau
     * @CreateTime 2021/9/7 11:30
     * @Desc 后台管理页面
     * @Params []
     * @Return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping()
    @ResponseBody
    public ModelAndView adminiStrator(){
        return new ModelAndView("adminiStrator");
    }

    @Autowired
    ILoginService iloginService;

    @Autowired
    RedisTemplate redisTemplate;

    /*
     * @Author ThorLau
     * @CreateTime 2021/8/31 16:12
     * @Desc 登录
     * @Params [java.lang.String, java.lang.String]
     * @Return java.lang.Object
     */
    @PostMapping(value = "/query")
    public Object queryUser(HttpServletRequest request) throws Exception {
        //编码问题
        request.setCharacterEncoding("utf-8");
        //拿到数据
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        BaseResponse baseResponse = iloginService.selectByName(name,passwd,"administrator");
        if (baseResponse.getRespCode() == CodeEnum.ALL_SUCCESS.getCode()){
            redisTemplate.opsForValue().set(request.getSession().getId()//key
                     ,baseResponse.getRespData()//value
            );
        }
        return baseResponse;
    }

    /**
     * @Author ThorLau
     * @CreateTime 2021/9/7 11:30
     * @Desc 登陆成功跳转页面
     * @Params []
     * @Return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping(value = "/goNext")
    @ResponseBody
    public ModelAndView goNext(){
        return new ModelAndView("administratorMain");
    }

    @GetMapping(value = "/querySession")
    @ResponseBody
    public Object querySession(HttpServletRequest request){
        return redisTemplate.opsForValue().get(request.getSession().getId());
    }
}
