package com.hivemq.edge.modules.adapters.factories;

import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface AdapterFactories {

    @NotNull AdapterSubscriptionFactory adapterSubscriptionFactory();

    @NotNull ApiExceptionFactory apiExceptionFactory(@NotNull String message);

    @NotNull PayloadFactory payloadFactory();

    @NotNull TypeIdentifierFactory TypeIdentifierFactory();

    @NotNull UserPropertyFactory userPropertyFactory();

    @NotNull EventBuilderFactory eventBuilderFactory();

    @NotNull DataPointFactory dataPointFactory();
}
