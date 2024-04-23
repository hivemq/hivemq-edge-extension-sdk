package com.hivemq.api.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

public interface Payload {


    public enum ContentType {

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




    @NotNull Payload.ContentType getContentType();

    @NotNull String getContent();
}
