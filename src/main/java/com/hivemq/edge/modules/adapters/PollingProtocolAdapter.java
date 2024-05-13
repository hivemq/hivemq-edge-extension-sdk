package com.hivemq.edge.modules.adapters;

import com.hivemq.edge.modules.adapters.data.ProtocolAdapterDataSample;
import com.hivemq.extension.sdk.api.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public interface PollingProtocolAdapter extends ProtocolAdapter {

    @NotNull CompletableFuture<? extends ProtocolAdapterDataSample> poll();

    default void onSamplerClosed(){
    }

     int getPollingIntervalMillis();

     int getMaxPollingErrorsBeforeRemoval();

}
