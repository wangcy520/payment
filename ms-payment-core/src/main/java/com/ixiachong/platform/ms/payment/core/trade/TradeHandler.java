/*
 * Project: Payment
 * Document: Handler
 * Date: 2020/8/7 7:24 下午
 * Author: wangbz
 *
 * Copyright © 2020 www.ixiachong.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳瞎充集团有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.ixiachong.platform.ms.payment.core.trade;

import com.ixiachong.commons.etc.exceptions.BaseException;

public interface TradeHandler<T, R> {
    R handle(TradeRequest<T> request) throws BaseException;
}
