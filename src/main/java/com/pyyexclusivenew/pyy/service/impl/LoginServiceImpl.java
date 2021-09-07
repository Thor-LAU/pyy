package com.pyyexclusivenew.pyy.service.impl;

import com.pyyexclusivenew.pyy.entity.Jurisdiction;
import com.pyyexclusivenew.pyy.entity.Login;
import com.pyyexclusivenew.pyy.mapper.JurisdictionMapper;
import com.pyyexclusivenew.pyy.mapper.LoginMapper;
import com.pyyexclusivenew.pyy.service.ILoginService;
import com.pyyexclusivenew.pyy.util.base.BaseResponse;
import com.pyyexclusivenew.pyy.util.code.CodeEnum;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author ThorLau
 * @CreateTime 2021/8/31 17:07
 * @Desc LoginServiceImpl
 */
@Service
public class LoginServiceImpl implements ILoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private ILoginService iLoginService;

    @Autowired
    public LoginMapper loginMapper;

    @Autowired
    public JurisdictionMapper jurisdictionMapper;

    @Override
    public BaseResponse selectByName(String name, String passwd ,String users) throws Exception{
        Jurisdiction jurisdiction;
        if (name == null || name.equals("")){
            return new BaseResponse(CodeEnum.USER_NAME_IS_NULL);
        }
        if (passwd == null || passwd.equals("")){
            return new BaseResponse(CodeEnum.USER_PASSWD_IS_NULL);
        }
        List<Login> user = loginMapper.selectByName(name);
        if (user.size() == 0){
            return new BaseResponse(CodeEnum.NOT_EXIST);
        } else {
            if (user.size() > 1){
                return new BaseResponse(CodeEnum.MORE_EXIST);
            } else {
                if (!user.get(0).getPasswd().equals(passwd)){
                    return new BaseResponse(CodeEnum.PASSWD_ERROR);
                }
                jurisdiction = jurisdictionMapper.selectById(user.get(0).getId());
                try{
                    if (jurisdiction.getJurisdiction().equals("") || jurisdiction.getJurisdiction() == null){
                        return new BaseResponse(CodeEnum.USER_JURISDICTION_IS_NULL);
                    }
                }catch (Exception e){
                    log.error("error: {}", ExceptionUtils.getStackTrace(e));
                    String s = ExceptionUtils.getStackTrace(e);
                    if (s.equals("error: java.lang.NullPointerException")){
                        return new BaseResponse(CodeEnum.USER_JURISDICTION_IS_NULL);
                    } else {
                        return new BaseResponse(CodeEnum.LOGIN_FAIL);
                    }
                }
                if (jurisdiction.getJurisdiction().equals(users)){
                    return new BaseResponse(CodeEnum.ALL_SUCCESS);
                } else {
                    if (users.equals("user")){
                        return new BaseResponse(CodeEnum.USER_IS_FOR_ADMINISTRATOR);
                    } else if (users.equals("administrator")){
                        return new BaseResponse(CodeEnum.USER_IS_FOR_USER);
                    } else {
                        return new BaseResponse(CodeEnum.USER_JURISDICTION_IS_NULL);
                    }

                }
            }
        }
    }
}
