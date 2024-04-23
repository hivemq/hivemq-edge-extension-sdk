package com.hivemq.edge.modules.adapters.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hivemq.edge.modules.config.AdapterSubscription;
import com.hivemq.edge.modules.config.ProtocolAdapterConfig;
import com.hivemq.edge.modules.config.UserProperty;
import com.hivemq.extension.sdk.api.annotations.NotNull;

import java.util.List;

public interface ProtocolAdapterDataSample<T extends ProtocolAdapterConfig> {
    @JsonIgnore
    AdapterSubscription getSubscription();

    @JsonIgnore
    String getTopic();

    @JsonIgnore
    int getQos();

    @JsonIgnore
    Long getTimestamp();

    @JsonIgnore
    List<UserProperty> getUserProperties();

    void setTimestamp(Long timestamp);

    void addDataPoint(@NotNull String tagName, @NotNull Object tagValue);

    void setDataPoints(List<DataPoint> list);

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<DataPoint> getDataPoints();
}
