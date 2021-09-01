package com.pyyexclusivenew.pyy.service.impl;

import com.pyyexclusivenew.pyy.entity.Login;
import com.pyyexclusivenew.pyy.mapper.LoginMapper;
import com.pyyexclusivenew.pyy.service.ILoginService;
import com.pyyexclusivenew.pyy.util.base.BaseResponse;
import com.pyyexclusivenew.pyy.util.code.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Author ThorLau
 * @CreateTime 2021/8/31 17:07
 * @Desc LoginServiceImpl
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private ILoginService iLoginService;

    @Autowired
    public LoginMapper loginMapper;

    @Override
    public BaseResponse selectByName(String name,String passwd) throws Exception{
        if (name == null || passwd == null || name.equals("") || passwd.equals("") ){
            return new BaseResponse(CodeEnum.IS_NULL);
        }
        List<Login> user = loginMapper.selectByName(name);
        if (user.size() == 0 && user == null){
            return new BaseResponse(CodeEnum.NOT_EXIST);
        } else {
            if (user.size() > 1){
                return new BaseResponse(CodeEnum.MORE_EXIST);
            } else {
                if (!user.get(0).getPasswd().equals(passwd)){
                    return new BaseResponse(CodeEnum.PASSWD_ERROR);
                }
                return new BaseResponse(CodeEnum.ALL_SUCCESS);
            }
        }
    }
}
