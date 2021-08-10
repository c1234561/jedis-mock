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
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Just to execute the command punsubscribe without error, no actual effect
 */
public class RO_punsubscribe extends AbstractRedisOperation {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(RO_unsubscribe.class);
    private OperationExecutorState state;

    public RO_punsubscribe(OperationExecutorState state, List<Slice> params) {
        super(state.base(), params);
        this.state = state;
    }

    Slice response() {
        List<Slice> channelsToUbsubscribeFrom;
        if(params().isEmpty()){
            LOG.debug("No channels specified therefore unsubscribing from all channels");
            channelsToUbsubscribeFrom = base().getSubscriptions(state.owner());
        } else {
            channelsToUbsubscribeFrom = params();
        }

        for (Slice channel : channelsToUbsubscribeFrom) {
            LOG.debug("Unsubscribing from channel [" + channel + "]");
            if(base().removeSubscriber(channel, state.owner())) {
                int numSubscriptions = base().getSubscriptions(state.owner()).size();
                Slice response = Response.unsubscribe(channel, numSubscriptions);
                state.owner().sendResponse(Response.clientResponse("unsubscribe", response), "unsubscribe");
            }
        }

        //Skip is sent because we have already responded
        return Response.SKIP;
    }
}
