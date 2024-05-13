package com.hivemq.extension.sdk.api.adapters.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hivemq.extension.sdk.api.adapters.config.AdapterSubscription;
import com.hivemq.extension.sdk.api.annotations.NotNull;

import java.util.List;

/**
 * Interface for data collected by a protocol adapter. The actual data points can be added via the addDataPoint method.
 *
 */
public interface ProtocolAdapterDataSample {
    /**
     * @return the {@link AdapterSubscription} containing information how the data gets published by the broker.
     */
    @JsonIgnore
    @NotNull AdapterSubscription getSubscription();

    /**
     * @return the timestamp when this data sample was taken.
     */
    @JsonIgnore
    @NotNull Long getTimestamp();

    /**
     * Adds a new data point to this sample.
     *
     * @param tagName the name for this data point.
     * @param tagValue the value for this data point.
     */
    void addDataPoint(@NotNull String tagName, @NotNull Object tagValue);

    /**
     * Sets/Overwrites all data points of the sample with the given argument.
     * @param list the new list of data points for this sample.
     */
    void setDataPoints(@NotNull List<DataPoint> list);

    /**
     * @return the list of data points
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @NotNull List<DataPoint> getDataPoints();
}
