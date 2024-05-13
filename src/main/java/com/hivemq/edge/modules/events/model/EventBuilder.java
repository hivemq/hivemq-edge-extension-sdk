package com.hivemq.edge.modules.events.model;

import com.hivemq.edge.modules.events.EventService;
import com.hivemq.extension.sdk.api.annotations.NotNull;

/**
 * Builder interface to create {@link Event} for the {@link EventService} to notify
 * HiveMQ Edge of any event regarding components such as protocol adapters.
 */
public interface EventBuilder {
    @NotNull EventBuilder withSeverity(Event.@NotNull SEVERITY severity);

    @NotNull EventBuilder withMessage(@NotNull String message);

    @NotNull EventBuilder withPayload(@NotNull Payload payload);

    @NotNull EventBuilder withTimestamp(@NotNull Long timestamp);

    @NotNull EventBuilder withAssociatedObject(@NotNull TypeIdentifier associatedObject);

    @NotNull EventBuilder withSource(@NotNull TypeIdentifier source);

    @NotNull Event build();
}
