package com.hivemq.edge.modules.config;

import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface UserProperty {
    @NotNull String getName();

    void setName(@NotNull String propertyName);

    @NotNull String getValue();

    void setValue(@NotNull String propertyValue);
}
