package com.hivemq.edge.modules.adapters.metrics;

import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface ProtocolAdapterMetricsHelper {
    void incrementReadPublishSuccess();

    void incrementReadPublishFailure();

    void incrementConnectionFailure();

    void incrementConnectionSuccess();

    void increment(@NotNull String metricName);

    void clearAll();
}
