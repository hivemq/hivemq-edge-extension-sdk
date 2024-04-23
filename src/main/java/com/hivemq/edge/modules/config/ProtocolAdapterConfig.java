package com.hivemq.edge.modules.config;

import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface ProtocolAdapterConfig extends CustomConfig {
    @NotNull String getId();

    void setId(String id);
}
