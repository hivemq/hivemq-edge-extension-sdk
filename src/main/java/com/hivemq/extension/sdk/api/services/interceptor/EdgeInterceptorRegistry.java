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
package com.hivemq.extension.sdk.api.services.interceptor;

import org.jetbrains.annotations.NotNull;
import com.hivemq.extension.sdk.api.interceptor.bridge.BridgePublishInboundInterceptor;
import com.hivemq.extension.sdk.api.interceptor.bridge.BridgePublishInboundInterceptorProvider;
import com.hivemq.extension.sdk.api.interceptor.bridge.BridgePublishOutboundInterceptor;
import com.hivemq.extension.sdk.api.interceptor.bridge.BridgePublishOutboundInterceptorProvider;
import com.hivemq.extension.sdk.api.interceptor.protocoladapter.ProtocolAdapterPublishInboundInterceptor;
import com.hivemq.extension.sdk.api.interceptor.protocoladapter.ProtocolAdapterPublishInboundInterceptorProvider;

/**
 * @since Edge 2023.1
 */
public interface EdgeInterceptorRegistry {

    /**
     * The provider is called once for each incoming PUBLISH message from a bridge.
     * <p>
     * The {@link BridgePublishInboundInterceptorProvider} must be implemented by the extension developer. It will
     * return an {@link BridgePublishInboundInterceptor} that can be used to modify incoming PUBLISH messages. If there
     * is already a provider present, it will be overwritten.
     *
     * @param bridgeInboundInterceptorProvider The provider to be registered.
     * @throws NullPointerException If the interceptor is null.
     * @since Edge 2023.1
     */
    void setBridgeInboundInterceptorProvider(
            @NotNull BridgePublishInboundInterceptorProvider bridgeInboundInterceptorProvider);

    /**
     * The provider is called once for each outgoing PUBLISH message to a bridge.
     * <p>
     * The {@link BridgePublishOutboundInterceptorProvider} must be implemented by the extension developer. It will
     * return an {@link BridgePublishOutboundInterceptor} that can be used to modify outgoing PUBLISH messages. If there
     * is already a provider present, it will be overwritten.
     *
     * @param bridgeOutboundInterceptorProvider The provider to be registered.
     * @throws NullPointerException If the interceptor is null.
     * @since Edge 2023.1
     */
    void setBridgeOutboundInterceptorProvider(
            @NotNull BridgePublishOutboundInterceptorProvider bridgeOutboundInterceptorProvider);


    /**
     * The provider is called once for each incoming PUBLISH message from a protocol adapter.
     * <p>
     * The {@link ProtocolAdapterPublishInboundInterceptorProvider} must be implemented by the extension developer. It
     * will return an {@link ProtocolAdapterPublishInboundInterceptor} that can be used to modify incoming PUBLISH
     * messages. If there is already a provider present, it will be overwritten.
     *
     * @param protocolAdapterInboundInterceptorProvider The provider to be registered.
     * @throws NullPointerException If the interceptor is null.
     * @since Edge 2023.1
     */
    void setProtocolAdapterInboundInterceptorProvider(
            @NotNull ProtocolAdapterPublishInboundInterceptorProvider protocolAdapterInboundInterceptorProvider);


}
