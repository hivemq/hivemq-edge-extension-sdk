package com.hivemq.edge.modules.adapters.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hivemq.api.model.core.Payload;
import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface PayloadFactory {

    @NotNull Payload create(final @NotNull Payload.ContentType contentType,
                            final @NotNull String content);


    @NotNull Payload create(final @NotNull ObjectMapper mapper, final @NotNull Object data);
}
