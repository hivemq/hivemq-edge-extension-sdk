package com.hivemq.edge.modules.config;

import java.util.List;

public interface AdapterSubscription {
    String getDestination();

    int getQos();

    MessageHandlingOptions getMessageHandlingOptions();

    Boolean getIncludeTimestamp();

    Boolean getIncludeTagNames();

    List<UserProperty> getUserProperties();

    enum MessageHandlingOptions {
        MQTTMessagePerTag,
        MQTTMessagePerSubscription
    }
}
