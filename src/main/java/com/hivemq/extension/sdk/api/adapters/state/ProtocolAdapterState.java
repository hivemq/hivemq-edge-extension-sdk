package com.hivemq.extension.sdk.api.adapters.state;

import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

public interface ProtocolAdapterState {

    @Nullable String getLastErrorMessage();

    enum RuntimeStatus {
        STARTED,
        STOPPED
    }

    enum ConnectionStatus {
        CONNECTED,
        DISCONNECTED,
        STATELESS,
        UNKNOWN,
        ERROR
    }


    boolean setConnectionStatus(@NotNull ConnectionStatus connectionStatus);

    @NotNull ConnectionStatus getConnectionStatus();

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

    void setRuntimeStatus(@NotNull RuntimeStatus runtimeStatus);

    @NotNull RuntimeStatus getRuntimeStatus();
}
