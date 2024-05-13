package com.hivemq.edge.modules.adapters.data;

import com.hivemq.extension.sdk.api.annotations.NotNull;

/**
 * Interface for data points gathered by a protocol adapter.
 * Instances of it can be created via {@link com.hivemq.edge.modules.adapters.factories.DataPointFactory} accessible via {@link com.hivemq.edge.modules.adapters.factories.AdapterFactories} in the {@link com.hivemq.edge.modules.adapters.model.ProtocolAdapterInput}.
 */
public interface DataPoint {
    /**
     * @return the value of the data point.
     */
    @NotNull Object getTagValue();

    /**
     * @return the tag of the data point.
     */
    @NotNull String getTagName();
}
