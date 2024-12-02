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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.hivemq.extension.sdk.api.client.parameter.ServerInformation;
import com.hivemq.extension.sdk.api.interceptor.bridge.parameter.BridgeInformation;
import com.hivemq.extension.sdk.api.interceptor.bridge.parameter.BridgeOutboundProviderInput;

/**
 * This is the input parameter of any {@link BridgePublishOutboundInterceptorProvider} providing
 * {@link ServerInformation} and {@link BridgeInformation}.
 *
 * @since Edge 2023.1
 */
public interface BridgePublishOutboundInterceptorProvider {

    /**
     * This method is called by HiveMQ for each outgoing PUBLISH message from a MQTT bridge.
     * <p>
     * Either the same {@link BridgePublishOutboundInterceptor} (stateless or must be thread-safe) or a new one
     * (stateful, must not be thread-safe) can be supplied on each call.
     * <p>
     * <code>null</code> can be returned if outgoing messages for a bridge should not be intercepted.
     *
     * @param input The {@link BridgeOutboundProviderInput}.
     * @return An implementation of the {@link BridgePublishOutboundInterceptor} or null if the PUBLISH should not be
     *         intercepted.
     * @since Edge 2023.1
     */
    @Nullable BridgePublishOutboundInterceptor getBridgePublishOutboundInterceptor(@NotNull BridgeOutboundProviderInput input);

}
