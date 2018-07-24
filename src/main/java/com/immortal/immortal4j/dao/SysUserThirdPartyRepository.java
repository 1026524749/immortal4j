package com.immortal.immortal4j.dao;

import com.immortal.immortal4j.entity.SysUserThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/11 0:30
 */
public interface SysUserThirdPartyRepository extends JpaRepository<SysUserThirdParty, Long>{
    /**
     * 根据Provider和openid查询第三方账号信息
     * @param provider
     * @param openId
     * @return
     */
    public SysUserThirdParty findByProviderAndOpenId(String provider,String openId);
}
