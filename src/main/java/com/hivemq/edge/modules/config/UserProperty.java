package com.hivemq.edge.modules.config;

import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface UserProperty {
    @NotNull String getPropertyName();

    void setPropertyName(@NotNull String propertyName);

    @NotNull String getPropertyValue();

    void setPropertyValue(@NotNull String propertyValue);
}
