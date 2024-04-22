package com.hivemq.protocols;

import com.fasterxml.jackson.databind.JsonNode;
import com.hivemq.edge.modules.api.adapters.model.ProtocolAdapterValidationFailure;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.networknt.schema.JsonSchema;

import java.io.IOException;
import java.util.List;

public interface ProtocolAdapterSchemaManager {
    JsonNode generateSchemaNode();

    JsonSchema generateSchema();

    List<ProtocolAdapterValidationFailure> validateJsonDocument(@NotNull byte[] jsonDocument) throws IOException;

    List<ProtocolAdapterValidationFailure> validateObject(@NotNull Object o);
}
