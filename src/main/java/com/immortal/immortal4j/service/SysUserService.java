package com.immortal.immortal4j.service;

import com.immortal.immortal4j.base.BaseService;
import com.immortal.immortal4j.entity.SysUser;
import com.immortal.immortal4j.support.login.ThirdPartyUser;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/22 16:23
 */
public interface SysUserService extends BaseService{
    /**
     * 根据第三方用户信息获取用户id
     * @param thirdPartyUser
     * @return
     */
    public Long queryUserIdByThirdParty(ThirdPartyUser thirdPartyUser);

    /**
     * 保存第三方用户信息
     * @param thirdPartyUser
     * @return
     */
    public SysUser insertThirdPartyUser(ThirdPartyUser thirdPartyUser);

}
