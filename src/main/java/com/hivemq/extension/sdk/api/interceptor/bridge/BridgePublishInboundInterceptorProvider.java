/*
 * Copyright 2023-present HiveMQ GmbH
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
package com.hivemq.extension.sdk.api.interceptor.bridge;

import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;
import com.hivemq.extension.sdk.api.client.parameter.ServerInformation;
import com.hivemq.extension.sdk.api.interceptor.bridge.parameter.BridgeInboundProviderInput;
import com.hivemq.extension.sdk.api.interceptor.bridge.parameter.BridgeInformation;

/**
 * This is the input parameter of any {@link BridgePublishInboundInterceptorProvider} providing
 * {@link ServerInformation} and {@link BridgeInformation}.
 *
 * @since Edge 2023.1
 */
public interface BridgePublishInboundInterceptorProvider {

    /**
     * This method is called by HiveMQ for each incoming PUBLISH message from a MQTT bridge.
     * <p>
     * Either the same {@link BridgePublishInboundInterceptor} (stateless or must be thread-safe) or a new one
     * (stateful, must not be thread-safe) can be supplied on each call.
     * <p>
     * <code>null</code> can be returned if incoming messages for a bridge should not be intercepted.
     *
     * @param input The {@link BridgeInboundProviderInput}.
     * @return An implementation of the {@link BridgePublishInboundInterceptor} or null if the PUBLISH should not be
     *         intercepted.
     * @since Edge 2023.1
     */
    @Nullable BridgePublishInboundInterceptor getBridgePublishInboundInterceptor(@NotNull BridgeInboundProviderInput input);

}
