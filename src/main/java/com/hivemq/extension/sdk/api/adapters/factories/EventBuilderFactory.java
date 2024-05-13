package com.hivemq.extension.sdk.api.adapters.factories;

import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.events.model.Event;
import com.hivemq.extension.sdk.api.events.model.EventBuilder;

public interface EventBuilderFactory {

    /**
     *
     * @param adapterId the id of the adapter for which the event is created
     * @param protocolId the protocol of the adapter for which the event is created
     * @return a {@link EventBuilder} to add further information and build an {@link Event}
     */
    @NotNull EventBuilder create(final @NotNull String adapterId, final @NotNull String protocolId);
}
