/*
 * Project: Accounts
 * Document: MerchantDao
 * Date: 2020/8/6 19:15
 * Author: fengzl
 *
 * Copyright © 2020 www.ixiachong.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳瞎充集团有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.ixiachong.platform.ms.payment.merchant.dao;

import com.ixiachong.platform.ms.payment.merchant.Const;
import com.ixiachong.platform.ms.payment.merchant.model.Merchant;
import com.ixiachong.platform.ms.payment.merchant.model.WithdrawConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author fengzl
 * @Date 2020/8/6
 */
public interface WithdrawConfigurationDao extends JpaRepository<WithdrawConfiguration, String> {
    List<WithdrawConfiguration> findAllByOwnerIdAndClassify(String ownerId, String classify);

    boolean existsByMerchantAndKeyAndValueAndClassifyIsNull(Merchant merchant, String key, String value);

    void deleteByOwnerIdAndKeyAndValueAndClassifyIsNull(String ownerId, String key, String value);

    void deleteByOwnerIdAndClassify(String ownerId, String classify);

    @Query("select o.value from WithdrawConfiguration o where o.ownerId = ?1 and o.key = '" + Const.CONFIGURATION_CHANNEL + "' and o.classify is null")
    List<String> getChannels(String ownerId);
}
