package com.hivemq.extension.sdk.api.adapters.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.events.model.Event;
import com.hivemq.extension.sdk.api.events.model.EventBuilder;
import com.hivemq.extension.sdk.api.events.model.Payload;

/**
 * Factory to create payloads for {@link Event}
 */
public interface PayloadFactory {

    /**
     * @param contentType the content type of the payload
     * @param content the content of the paylaod
     * @return {@link Payload} to be used in {@link EventBuilder}
     */
    @NotNull Payload create(final @NotNull Payload.ContentType contentType,
                            final @NotNull String content);


    /**
     * @param mapper the {@link ObjectMapper} that is used to create a Json from the object
     * @param data a Jackson annotated Object from which the object mapper creates a json from.
     * @return {@link Payload} to be used in {@link EventBuilder}
     */
    @NotNull Payload create(final @NotNull ObjectMapper mapper, final @NotNull Object data);
}
