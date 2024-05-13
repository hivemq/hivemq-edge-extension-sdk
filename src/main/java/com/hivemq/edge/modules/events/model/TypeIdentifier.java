package com.hivemq.edge.modules.events.model;

import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface TypeIdentifier {

    enum TYPE {
        BRIDGE, ADAPTER, ADAPTER_TYPE, EVENT, USER
    }

    TypeIdentifier.@NotNull TYPE getType();

    @NotNull String getIdentifier();

    @NotNull String getFullQualifiedIdentifier();

}
