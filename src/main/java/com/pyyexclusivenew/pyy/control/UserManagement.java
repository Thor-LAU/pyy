package com.pyyexclusivenew.pyy.control;

import com.pyyexclusivenew.pyy.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/userManagement")
public class UserManagement {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    /**
     * @Author ThorLau
     * @CreateTime 2021/9/18 16:49
     * @Desc
     * @Params []
     * @Return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping()
    @ResponseBody
    public ModelAndView userManagement(){
        return new ModelAndView("userManagement");
    }
}
