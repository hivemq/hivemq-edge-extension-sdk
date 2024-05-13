package com.hivemq.extension.sdk.api.adapters;

import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;

public enum ProtocolAdapterCategory {
    CONNECTIVITY("Connectivity", "A standard connectivity based protocol, typically web standard.", null),
    INDUSTRIAL("Industrial", "Industrial, typically field bus protocols.", null),
    BUILDING_AUTOMATION("Building Automation", "Protocols related to building automation", null),
    SIMULATION("Simulation", "Simulation protocols, that emulate real world devices", null);

    ProtocolAdapterCategory(
            final @NotNull String displayName,
            final @NotNull String description,
            final @Nullable String image) {
        this.displayName = displayName;
        this.image = image;
        this.description = description;
    }

    final @NotNull String displayName;
    final @NotNull String description;
    final @Nullable String image;

    public @NotNull String getDisplayName() {
        return displayName;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public @Nullable String getImage() {
        return image;
    }
}
