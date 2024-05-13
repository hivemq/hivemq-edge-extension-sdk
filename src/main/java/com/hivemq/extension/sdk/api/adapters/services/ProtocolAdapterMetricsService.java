package com.hivemq.extension.sdk.api.adapters.services;

import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface ProtocolAdapterMetricsService {

    String PROTOCOL_ADAPTER_PREFIX = "com.hivemq.edge.protocol-adapters.";

    void incrementReadPublishSuccess();

    void incrementReadPublishFailure();

    void incrementConnectionFailure();

    void incrementConnectionSuccess();

    void increment(@NotNull String metricName);

    void clearAll();
}
