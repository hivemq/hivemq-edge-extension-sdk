/*
 * Copyright 2019-present HiveMQ GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hivemq.extension.sdk.api.adapters;

import com.hivemq.extension.sdk.api.adapters.discovery.ProtocolAdapterDiscoveryInput;
import com.hivemq.extension.sdk.api.adapters.discovery.ProtocolAdapterDiscoveryOutput;
import com.hivemq.extension.sdk.api.adapters.model.ProtocolAdapterStartInput;
import com.hivemq.extension.sdk.api.adapters.model.ProtocolAdapterStartOutput;
import com.hivemq.extension.sdk.api.annotations.NotNull;

import java.util.concurrent.CompletableFuture;


/**
 * A protocol adapter is the resource responsible for connecting to and providing data from disparate remote or local
 * device. The implementation must manage its resources internally, and adhere to the semantic lifecycle applied to the
 * adapter instances.
 * <p>
 *
 * @since 2023.1
 */
public interface ProtocolAdapter {

    /**
     * The adapter Id represents a unique id/name of the instance within the runtime. This value should be considered
     * immutable.
     *
     * @return A string ID conform to the regex ([a-zA-Z_0-9-_])* which uniquely identifies the instance of
     *         the adapter.
     */
    @NotNull String getId();


    // TODO why return the output. Just set the status like we always
    /**
     * Start the adapter, establishing a connection to any internal or external device using the configuration supplied
     * during instantiation.
     *
     * @param input  - the state associated with runtime. Allows the adapter to bind to required services in a decoupled
     *               manner
     * @param output - the output resulting from the start operation. The adapter will
     */
     void start(
             @NotNull ProtocolAdapterStartInput input, @NotNull ProtocolAdapterStartOutput output);

    /**
     * Stop the adapter. Stopping the adapter will release any network interface connections or local resources
     * associated with the connection to the device. State relating to the connection however will be retained allowing
     * the start method to restart the adapter.
     *
     * @return a completable future which can be used to check on the status of the stop operation.
     */
    @NotNull CompletableFuture<Void> stop();

    default @NotNull CompletableFuture<Void> discoverValues(
            @NotNull ProtocolAdapterDiscoveryInput input,
            @NotNull ProtocolAdapterDiscoveryOutput output) {
        return CompletableFuture.failedFuture(new UnsupportedOperationException(
                "Adapter type does not support discovery"));
    }

    @NotNull ProtocolAdapterInformation getProtocolAdapterInformation();

    /**
     * Called by the framework when the instance will be discarded
     */
    default void destroy() {

    }
}
