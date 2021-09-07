package com.pyyexclusivenew.pyy.service;

import com.pyyexclusivenew.pyy.util.base.BaseResponse;

/*
 * @Author ThorLau
 * @CreateTime 2021/8/31 17:07
 * @Desc LoginService
 */
public interface ILoginService {
    BaseResponse selectByName(String name, String passwd, String jurisdiction) throws Exception;
}
