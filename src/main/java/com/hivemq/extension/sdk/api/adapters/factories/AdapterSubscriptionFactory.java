package com.hivemq.extension.sdk.api.adapters.factories;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hivemq.extension.sdk.api.adapters.config.AdapterSubscription;
import com.hivemq.extension.sdk.api.adapters.config.UserProperty;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

import java.util.List;

public interface AdapterSubscriptionFactory {

    /**
     * @param destination    the mqtt topic on which the data should be published
     * @param qos            the mqtt qos for the data
     * @param userProperties mqtt user properties for the publish that will contain the data
     * @return an {@link AdapterSubscription} containing information how the data will be published.
     */
    @NotNull AdapterSubscription create(
            @JsonProperty("destination") @Nullable final String destination,
            @JsonProperty("qos") final int qos,
            @JsonProperty("userProperties") @Nullable List<UserProperty> userProperties);
}
