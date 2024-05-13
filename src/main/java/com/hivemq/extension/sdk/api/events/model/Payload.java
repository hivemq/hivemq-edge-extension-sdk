package com.hivemq.extension.sdk.api.events.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Payload of an {@link Event} representing information on the event
 */
public interface Payload {

     enum ContentType {

        JSON ("application/json"),
        PLAIN_TEXT ("text/plain"),
        XML ("text/xml"),
        CSV ("text/csv");

        ContentType (final @NotNull String contentType){
            this.contentType = contentType;
        }

        @JsonProperty("contentType")
        @Schema(description = "The official representation of the content type")
        final @NotNull String contentType;

        public @NotNull String getContentType() {
            return contentType;
        }
    }

    /**
     * @return the content type of the payload
     */

    @NotNull Payload.ContentType getContentType();

    /**
     * @return the content of the payload
     */
    @NotNull String getContent();
}
