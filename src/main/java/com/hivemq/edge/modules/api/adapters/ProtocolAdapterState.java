package com.hivemq.edge.modules.api.adapters;

import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

public interface ProtocolAdapterState {

    boolean setConnectionStatus(@NotNull ProtocolAdapter.ConnectionStatus connectionStatus);

    @NotNull ProtocolAdapter.ConnectionStatus getConnectionStatus();

    void setErrorConnectionStatus(
            @NotNull String adapterId,
            @NotNull String protocolId,
            @Nullable Throwable t,
            @Nullable String errorMessage);

    void reportErrorMessage(
            @NotNull String adapterId,
            @NotNull String protocolId,
            @Nullable Throwable throwable,
            @Nullable String errorMessage,
            boolean sendEvent);

    void setRuntimeStatus(@NotNull ProtocolAdapter.RuntimeStatus runtimeStatus);

    @NotNull ProtocolAdapter.RuntimeStatus getRuntimeStatus();
}
