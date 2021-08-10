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

package com.github.fppt.jedismock.storage;

import com.github.fppt.jedismock.server.Slice;
import com.google.common.collect.Table;

import java.util.Map;

public class AutoValue_ExpiringKeyValueStorage extends ExpiringKeyValueStorage {
    private final Table<Slice, Slice, Slice> values;
    private final Map<Slice, Long> ttls;

    AutoValue_ExpiringKeyValueStorage(Table<Slice, Slice, Slice> values, Map<Slice, Long> ttls) {
        if (values == null) {
            throw new NullPointerException("Null values");
        } else {
            this.values = values;
            if (ttls == null) {
                throw new NullPointerException("Null ttls");
            } else {
                this.ttls = ttls;
            }
        }
    }

    public Table<Slice, Slice, Slice> values() {
        return this.values;
    }

    public Map<Slice, Long> ttls() {
        return this.ttls;
    }

    public String toString() {
        return "ExpiringKeyValueStorage{values=" + this.values + ", ttls=" + this.ttls + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ExpiringKeyValueStorage)) {
            return false;
        } else {
            ExpiringKeyValueStorage that = (ExpiringKeyValueStorage) o;
            return this.values.equals(that.values()) && this.ttls.equals(that.ttls());
        }
    }

    public int hashCode() {
        int h$ = 1;
        h$ = h$ * 1000003;
        h$ ^= this.values.hashCode();
        h$ *= 1000003;
        h$ ^= this.ttls.hashCode();
        return h$;
    }
}
