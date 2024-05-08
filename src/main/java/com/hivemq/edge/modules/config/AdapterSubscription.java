package com.hivemq.edge.modules.config;

import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

import java.util.List;

// TODO the name is still bad
public interface AdapterSubscription {
    @Nullable String getDestination();

    int getQos();

    @NotNull MessageHandlingOptions getMessageHandlingOptions();

    @NotNull Boolean getIncludeTimestamp();

    @NotNull Boolean getIncludeTagNames();

    @NotNull List<UserProperty> getUserProperties();

    enum MessageHandlingOptions {
        MQTTMessagePerTag,
        MQTTMessagePerSubscription
    }
}
