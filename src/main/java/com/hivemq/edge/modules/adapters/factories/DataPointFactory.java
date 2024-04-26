package com.hivemq.edge.modules.adapters.factories;

import com.hivemq.edge.modules.adapters.data.DataPoint;
import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface DataPointFactory {

   @NotNull DataPoint create(final @NotNull String tagName, final @NotNull Object tagValue);
}
