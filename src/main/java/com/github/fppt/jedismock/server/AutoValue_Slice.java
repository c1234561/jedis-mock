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

package com.github.fppt.jedismock.server;

public class AutoValue_Slice extends Slice{
    private final byte[] data;
    private static final long serialVersionUID = 247772234876073528L;

    AutoValue_Slice(byte[] data) {
        if (data == null) {
            throw new NullPointerException("Null data");
        } else {
            this.data = data;
        }
    }

    @Override
    public byte[] data() {
        return this.data;
    }
}
