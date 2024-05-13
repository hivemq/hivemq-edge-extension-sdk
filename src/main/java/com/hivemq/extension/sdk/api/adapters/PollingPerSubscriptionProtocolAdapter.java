package com.hivemq.extension.sdk.api.adapters;

import com.hivemq.extension.sdk.api.adapters.config.AdapterSubscription;
import com.hivemq.extension.sdk.api.adapters.data.ProtocolAdapterDataSample;
import com.hivemq.extension.sdk.api.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PollingPerSubscriptionProtocolAdapter extends ProtocolAdapter {

    @NotNull CompletableFuture<? extends ProtocolAdapterDataSample> poll(@NotNull AdapterSubscription adapterSubscription);

    @NotNull List<? extends AdapterSubscription> getSubscriptions();

    int getPollingIntervalMillis();

    int getMaxPollingErrorsBeforeRemoval();

    default void onSamplerClosed() {

    }

}
