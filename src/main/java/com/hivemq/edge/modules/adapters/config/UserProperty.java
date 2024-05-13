package com.hivemq.edge.modules.adapters.config;

import com.hivemq.extension.sdk.api.annotations.NotNull;

/**
 * Interface for parsing mqtt user properties in adapter configurations.
 * The UserPropertyImpl in the HiveMQ Edge code will be used automatically to create instances during conversion:
 *
 *     @JsonProperty("propertyName")
 *     @ModuleConfigField(title = "Property Name", description = "Name of the associated property")
 *     private @Nullable String propertyName = null;
 *
 *     @JsonProperty("propertyValue")
 *     @ModuleConfigField(title = "Property Value", description = "Value of the associated property")
 *     private @Nullable String propertyValue = null;
 */
public interface UserProperty {
    @NotNull String getName();

    void setName(@NotNull String propertyName);

    @NotNull String getValue();

    void setValue(@NotNull String propertyValue);
}
