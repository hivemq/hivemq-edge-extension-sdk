package com.hivemq.edge.model;

import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface TypeIdentifier {

    public enum TYPE {
        BRIDGE, ADAPTER, ADAPTER_TYPE, EVENT, USER
    }

    TypeIdentifier.@NotNull TYPE getType();

    @NotNull String getIdentifier();

    @NotNull String getFullQualifiedIdentifier();

}
