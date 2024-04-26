package com.hivemq.edge.modules.adapters.factories;

import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface ApiExceptionFactory {

    @NotNull Exception create();

}
