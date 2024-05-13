package com.hivemq.edge.modules.adapters.factories;

import com.hivemq.edge.modules.events.model.EventBuilder;
import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface EventBuilderFactory {

    @NotNull EventBuilder create(final @NotNull String id, final @NotNull String protocolId);
}
