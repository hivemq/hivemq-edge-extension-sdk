package com.hivemq.edge.modules.adapters.factories;

import com.hivemq.edge.modules.config.UserProperty;
import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface UserPropertyFactory {

    @NotNull UserProperty create(final @NotNull String name, final @NotNull String value);

}
