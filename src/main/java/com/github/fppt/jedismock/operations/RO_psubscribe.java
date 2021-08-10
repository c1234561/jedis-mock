/*
 * MCHR CONFIDENTIAL
 *
 * Copyright (c) 2020-2021 mchrcloud.com
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of MCHR Incorporated and its suppliers, if any.
 * The intellectual and technical concepts contained
 * herein are proprietary to MCHR Incorporated and its suppliers
 * and may be covered by Chinese and Foreign Patents, patents in process,
 * and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from MCHR Incorporated.
 */

package com.github.fppt.jedismock.operations;

import com.github.fppt.jedismock.server.Response;
import com.github.fppt.jedismock.server.Slice;
import com.github.fppt.jedismock.storage.OperationExecutorState;

import java.util.List;

/**
 * Just to execute the command psubscribe without error, no actual effect
 */
public class RO_psubscribe extends AbstractRedisOperation {
    private OperationExecutorState state;

    public RO_psubscribe(OperationExecutorState state, List<Slice> params) {
        super(state.base(), params);
        this.state = state;
    }

    Slice response() {
        params().forEach(channel -> base().addSubscriber(channel, state.owner()));
        List<Slice> numSubscriptions = base().getSubscriptions(state.owner());

        return Response.subscribedToChannel(numSubscriptions);
    }
}
