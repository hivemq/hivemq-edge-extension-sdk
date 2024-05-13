package com.hivemq.extension.sdk.api.adapters.config;

import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

import java.util.List;

// TODO the name is still bad
public interface AdapterSubscription {

    /**
     * @return the topic on which the data will be available
     */
    @Nullable String getDestination();

    /**
     * @return the Quality-of-Service for the publish containing the data
     */
    int getQos();

    /**
     * @return how the data will be published (one publish for all tags, a separate publish for each tag)
     */
    @NotNull MessageHandlingOptions getMessageHandlingOptions();

    /**
     * @return whether the publish should contain the timestamp
     */
    @NotNull Boolean getIncludeTimestamp();

    /**
     * @return whether the publish should include tag names
     */
    @NotNull Boolean getIncludeTagNames();

    /**
     * @return a list of MQTT user properties that get added to the publish
     */
    @NotNull List<UserProperty> getUserProperties();

}
