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

public class AutoValue_ServiceOptions extends ServiceOptions {
    private final int autoCloseOn;

    AutoValue_ServiceOptions(int autoCloseOn) {
        this.autoCloseOn = autoCloseOn;
    }

    @Override
    public int autoCloseOn() {
        return this.autoCloseOn;
    }

    @Override
    public String toString() {
        return "ServiceOptions{autoCloseOn=" + this.autoCloseOn + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof ServiceOptions) {
            ServiceOptions that = (ServiceOptions) o;
            return this.autoCloseOn == that.autoCloseOn();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int h$ = 1;
        h$ = h$ * 1000003;
        h$ ^= this.autoCloseOn;
        return h$;
    }
}
