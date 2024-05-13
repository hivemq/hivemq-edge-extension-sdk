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
package com.hivemq.extension.sdk.api.adapters.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hivemq.extension.sdk.api.adapters.ProtocolAdapter;
import com.hivemq.extension.sdk.api.adapters.ProtocolAdapterInformation;
import com.hivemq.extension.sdk.api.adapters.config.ProtocolAdapterConfig;
import com.hivemq.extension.sdk.api.adapters.model.ProtocolAdapterInput;
import com.hivemq.extension.sdk.api.annotations.NotNull;

import java.util.Map;

/**
 * The factory is responsible for constructing and managing the lifecycle of the various aspects of the adapter
 * sub-systems. We bind this to the configuration types to we can provide tightly coupled implementation instances
 * responsible for adapter management.
 */
public interface ProtocolAdapterFactory<E extends ProtocolAdapterConfig> {

    /**
     * Returns Metadata related to the protocol adapter instance, including descriptions, iconography, categorisation et
     * al
     *
     * @return the instance that provides the adapter information
     */
    @NotNull ProtocolAdapterInformation getInformation();

    /**
     * This method is called by HiveMQ Edge to create an instance of the adapter
     *
     * @param adapterInformation the information on the adapter
     * @param input              wrapper object for various information for the adapter.
     * @return the protocol adapter instance
     */
    @NotNull ProtocolAdapter createAdapter(
            @NotNull ProtocolAdapterInformation adapterInformation, @NotNull ProtocolAdapterInput<E> input);

    /**
     * @param objectMapper the object mapper that converts the map to the actual config
     * @param config       a map containing the configuration of the adapter
     * @return a parsed confif object for this adapter
     */
    @NotNull E convertConfigObject(final @NotNull ObjectMapper objectMapper, final @NotNull Map<String, Object> config);

    /**
     * @param objectMapper the object mapper that converts the actual config to a map
     * @param config       the config for this adapter
     * @return a map containing the configuration of the adapter
     */
    @NotNull Map<String, Object> unconvertConfigObject(
            final @NotNull ObjectMapper objectMapper, final @NotNull ProtocolAdapterConfig config);

    /**
     * A bean class that will be reflected upon by the framework to determine the structural requirements of the
     * configuration associated with an adapter instance. It is expected that the bean class supplied, be marked up
     * with
     *
     * @return The class that represents (and will encapsulate) the configuration requirements of the adapter
     * @ModuleConfigField annotations.
     */
    @NotNull Class<E> getConfigClass();
}
