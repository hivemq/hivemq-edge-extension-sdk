package com.hivemq.edge.modules.adapters.factories;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hivemq.edge.modules.adapters.config.AdapterSubscription;
import com.hivemq.edge.modules.adapters.config.UserProperty;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

import java.util.List;

public interface AdapterSubscriptionFactory {

    @NotNull AdapterSubscription create(
            @JsonProperty("destination") @Nullable final String destination,
            @JsonProperty("qos") final int qos,
            @JsonProperty("userProperties") @Nullable List<UserProperty> userProperties);
}
