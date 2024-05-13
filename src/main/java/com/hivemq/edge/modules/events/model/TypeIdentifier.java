package com.hivemq.edge.modules.events.model;

import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface TypeIdentifier {

    enum Type {
        BRIDGE, ADAPTER, ADAPTER_TYPE, EVENT, USER
    }

    @NotNull Type getType();

    @NotNull String getIdentifier();

    @NotNull String getFullQualifiedIdentifier();

}
