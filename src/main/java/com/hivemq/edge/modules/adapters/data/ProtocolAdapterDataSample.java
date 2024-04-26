package com.hivemq.edge.modules.adapters.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hivemq.edge.modules.config.AdapterSubscription;
import com.hivemq.edge.modules.config.UserProperty;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

import java.util.List;

public interface ProtocolAdapterDataSample {
    @JsonIgnore
    @NotNull AdapterSubscription getSubscription();

    @JsonIgnore
    @Nullable String getTopic();

    @JsonIgnore
    int getQos();

    @JsonIgnore
    @NotNull Long getTimestamp();

    @JsonIgnore
    @NotNull List<UserProperty> getUserProperties();

    void setTimestamp(@NotNull Long timestamp);

    void addDataPoint(@NotNull String tagName, @NotNull Object tagValue);

    void setDataPoints(@NotNull List<DataPoint> list);

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @NotNull List<DataPoint> getDataPoints();
}
