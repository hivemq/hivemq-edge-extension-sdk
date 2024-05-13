package com.hivemq.extension.sdk.api.events.model;

import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.events.EventService;

/**
 * Builder interface to create {@link Event} for the {@link EventService} to notify HiveMQ Edge of any event regarding
 * components such as protocol adapters.
 */
public interface EventBuilder {
    /**
     * @param severity the severity of the event
     * @return the builder for a fluent api
     */
    @NotNull EventBuilder withSeverity(Event.@NotNull SEVERITY severity);

    /**
     * @param message the message of the event
     * @return the builder for a fluent api
     */
    @NotNull EventBuilder withMessage(@NotNull String message);

    /**
     * @param payload the payload of the event
     * @return the builder for a fluent api
     */
    @NotNull EventBuilder withPayload(@NotNull Payload payload);

    /**
     * @param timestamp the unix timestamp of this event
     * @return the builder for a fluent api
     */
    @NotNull EventBuilder withTimestamp(@NotNull Long timestamp);

    /**
     * @param associatedObject the type identifier of the associated object for this event
     * @return the builder for a fluent api
     */
    @NotNull EventBuilder withAssociatedObject(@NotNull TypeIdentifier associatedObject);

    /**
     * @param source the type identifier of the source of this evemt
     * @return the builder for a fluent api
     */
    @NotNull EventBuilder withSource(@NotNull TypeIdentifier source);

    /**
     * @return the Event based on the input
     */
    @NotNull Event build();
}
