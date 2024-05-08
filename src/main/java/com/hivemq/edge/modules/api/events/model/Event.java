package com.hivemq.edge.modules.api.events.model;

import com.hivemq.edge.model.Identifiable;
import com.hivemq.edge.model.TypeIdentifier;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

/**
 * Interface for events for the {@link com.hivemq.edge.modules.api.events.EventService}.
 */
public interface Event extends Identifiable {
    @NotNull SEVERITY getSeverity();

    @NotNull String getMessage();

    @Nullable Payload getPayload();

    @NotNull Long getCreated();

    @NotNull Long getTimestamp();

    @Nullable TypeIdentifier getAssociatedObject();

    @Nullable TypeIdentifier getSource();

    @Override
    TypeIdentifier getIdentifier();

    public enum SEVERITY {
        INFO,
        WARN,
        ERROR,
        CRITICAL
    }
}
