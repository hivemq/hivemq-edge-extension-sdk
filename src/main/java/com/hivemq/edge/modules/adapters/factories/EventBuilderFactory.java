package com.hivemq.edge.modules.adapters.factories;

import com.hivemq.edge.modules.events.model.EventBuilder;
import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface EventBuilderFactory {

    /**
     *
     * @param adapterId the id of the adapter for which the event is created
     * @param protocolId the protocol of the adapter for which the event is created
     * @return a {@link EventBuilder} to add further information and build an {@link com.hivemq.edge.modules.events.model.Event}
     */
    @NotNull EventBuilder create(final @NotNull String adapterId, final @NotNull String protocolId);
}
