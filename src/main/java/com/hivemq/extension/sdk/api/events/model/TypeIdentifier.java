package com.hivemq.extension.sdk.api.events.model;

import com.hivemq.extension.sdk.api.annotations.NotNull;

/**
 * Interface for a unique type identifier used by Edge to reference various entities, e.g. bridges or adapters.
 */
public interface TypeIdentifier {

    enum Type {
        BRIDGE, ADAPTER, ADAPTER_TYPE, EVENT, USER
    }

    /**
     * @return the type of entity of this identifier
     */
    @NotNull Type getType();

    /**
     * @return a string representing the unique id
     */
    @NotNull String getIdentifier();

    /**
     * @return composition of type and identifier
     */
    @NotNull String getFullQualifiedIdentifier();

}
