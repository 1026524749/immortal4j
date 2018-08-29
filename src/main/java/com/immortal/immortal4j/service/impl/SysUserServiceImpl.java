package com.immortal.immortal4j.service.impl;

import com.immortal.immortal4j.base.BaseServiceImpl;
import com.immortal.immortal4j.dao.SysUserRepository;
import com.immortal.immortal4j.dao.SysUserThirdPartyRepository;
import com.immortal.immortal4j.entity.SysUser;
import com.immortal.immortal4j.entity.SysUserThirdParty;
import com.immortal.immortal4j.service.SysUserService;
import com.immortal.immortal4j.support.login.ThirdPartyUser;
import com.immortal.immortal4j.utils.SecurityUtil;
import org.apache.commons.lang3.ThreadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/7/22 16:25
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl implements SysUserService{
    @Autowired
    private SysUserRepository repository;
    @Autowired
    private SysUserThirdPartyRepository thirdPartyRepository;

    @Override
    protected JpaRepository getDefaultRepository() {
        return repository;
    }

    @Override
    public Long queryUserIdByThirdParty(ThirdPartyUser thirdPartyUser) {
        return thirdPartyRepository.findByProviderAndOpenId(thirdPartyUser.getProvider(), thirdPartyUser.getOpenid()).getUserId();
    }

    @Override
    public SysUser insertThirdPartyUser(ThirdPartyUser thirdPartyUser) {
        SysUser sysUser = new SysUser();
        sysUser.setSex(0);
        sysUser.setUserType("1");
        sysUser.setPassword(SecurityUtil.encryptPassword("123456"));
        sysUser.setUserName(thirdPartyUser.getUserName());
        sysUser.setAvatar(thirdPartyUser.getAvatarUrl());

        SysUserThirdParty thirdUser = new SysUserThirdParty();
        thirdUser.setOpenId(thirdPartyUser.getOpenid());
        thirdUser.setProvider(thirdPartyUser.getProvider());
        thirdUser.setCreateTime(new Date());

        //更新账号等信息
        sysUser = (SysUser)this.update(sysUser,1L);
        sysUser.setAccount(thirdUser.getProvider()+sysUser.getId());
        this.update(sysUser,sysUser.getId());

        //保存第三方信息
        thirdUser.setUserId(sysUser.getId());

        return null;
    }

}
