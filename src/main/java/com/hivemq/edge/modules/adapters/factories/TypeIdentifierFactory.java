package com.hivemq.edge.modules.adapters.factories;

import com.hivemq.edge.modules.events.model.TypeIdentifier;
import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface TypeIdentifierFactory {

    @NotNull TypeIdentifier create(final @NotNull TypeIdentifier.TYPE type, final @NotNull String identifier);
}
