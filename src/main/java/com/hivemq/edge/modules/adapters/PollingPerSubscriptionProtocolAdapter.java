package com.hivemq.edge.modules.adapters;

import com.hivemq.edge.modules.adapters.data.ProtocolAdapterDataSample;
import com.hivemq.edge.modules.api.adapters.ProtocolAdapter;
import com.hivemq.edge.modules.config.AdapterSubscription;
import com.hivemq.extension.sdk.api.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PollingPerSubscriptionProtocolAdapter extends ProtocolAdapter {

    @NotNull CompletableFuture<? extends ProtocolAdapterDataSample> poll(@NotNull AdapterSubscription adapterSubscription);

    @NotNull List<? extends AdapterSubscription> getSubscriptions();
}
