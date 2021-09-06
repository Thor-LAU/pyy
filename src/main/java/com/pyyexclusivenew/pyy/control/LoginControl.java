package com.pyyexclusivenew.pyy.control;

import com.pyyexclusivenew.pyy.service.ILoginService;
import com.pyyexclusivenew.pyy.service.impl.LoginServiceImpl;
import com.pyyexclusivenew.pyy.util.base.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/*
 * @Author ThorLau
 * @CreateTime 2021/8/31 16:11
 * @Desc 登录的Controller
 */
@RestController
@RequestMapping(value = "/login")
public class LoginControl {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

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
        return iloginService.selectByName(name,passwd);
    }

    @GetMapping(value = "/goNext")
    @ResponseBody
    public ModelAndView goNext(){
        return new ModelAndView("mainP");
    }
}



