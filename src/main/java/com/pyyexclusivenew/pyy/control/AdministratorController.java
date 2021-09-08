package com.pyyexclusivenew.pyy.control;

import com.pyyexclusivenew.pyy.service.ILoginService;
import com.pyyexclusivenew.pyy.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    /*
     * @Author ThorLau
     * @CreateTime 2021/8/31 16:12
     * @Desc 登录
     * @Params [java.lang.String, java.lang.String]
     * @Return java.lang.Object
     */
    @PostMapping(value = "/query")
    public Object queryUser(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "passwd", required = false) String passwd) throws Exception{
        return iloginService.selectByName(name,passwd,"administrator");
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
}
