package com.hivemq.edge.modules.events.model;

import com.hivemq.edge.modules.events.EventService;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

/**
 * Interface for events for the {@link EventService}.
 */
public interface Event {
    @NotNull SEVERITY getSeverity();

    @NotNull String getMessage();

    @Nullable Payload getPayload();

    @NotNull Long getCreated();

    @NotNull Long getTimestamp();

    @Nullable TypeIdentifier getAssociatedObject();

    @Nullable TypeIdentifier getSource();

    /**
     * Represents a uniquely identifiable object in the system.
     * @return The system-wide identifier of the object
     */
    @NotNull TypeIdentifier getIdentifier();

    public enum SEVERITY {
        INFO,
        WARN,
        ERROR,
        CRITICAL
    }
}
