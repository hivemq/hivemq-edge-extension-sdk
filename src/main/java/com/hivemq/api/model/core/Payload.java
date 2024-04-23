package com.hivemq.api.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public interface Payload {


    public enum ContentType {

        JSON ("application/json"),
        PLAIN_TEXT ("text/plain"),
        XML ("text/xml"),
        CSV ("text/csv");

        ContentType (final String contentType){
            this.contentType = contentType;
        }

        @JsonProperty("contentType")
        @Schema(description = "The official representation of the content type")
        final String contentType;

        public String getContentType() {
            return contentType;
        }
    }




    Payload.ContentType getContentType();

    String getContent();
}
