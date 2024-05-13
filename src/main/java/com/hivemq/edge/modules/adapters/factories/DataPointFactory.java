package com.hivemq.edge.modules.adapters.factories;

import com.hivemq.edge.modules.adapters.data.DataPoint;
import com.hivemq.extension.sdk.api.annotations.NotNull;

public interface DataPointFactory {

    /**
     * @param tagName the name for this data point
     * @param tagValue the value for this data point
     * @return a {@link DataPoint} containing the name and value.
     */
   @NotNull DataPoint create(final @NotNull String tagName, final @NotNull Object tagValue);
}
