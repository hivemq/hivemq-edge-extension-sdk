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
import com.hivemq.extension.sdk.api.interceptor.Interceptor;
import com.hivemq.extension.sdk.api.interceptor.bridge.parameter.BridgePublishOutboundInput;
import com.hivemq.extension.sdk.api.interceptor.bridge.parameter.BridgePublishOutboundOutput;

/**
 * Interface for the publish outbound interception.
 * <p>
 * Interceptors are always called by the same thread for all messages for the same client.
 * <p>
 * If the same instance is shared between multiple clients it can be called by different threads and must therefore be
 * thread-safe.
 * <p>
 *
 * @author Christoph Schaebel
 * @since 1.0.0
 */
@FunctionalInterface
public interface BridgePublishOutboundInterceptor extends Interceptor {

    /**
     * When a {@link BridgePublishOutboundInterceptor} is set through any extension, this method gets called for every outbound
     * PUBLISH packet that originates from any forwarded topic from any MQTT bridge.
     * <p>
     * When the extension is enabled after HiveMQ is already running, this method will also be called for future
     * PUBLISHes of clients that are already connected.
     *
     * @param publishOutboundInput  The {@link BridgePublishOutboundInput} parameter.
     * @param publishOutboundOutput The {@link BridgePublishOutboundOutput} parameter.
     * @since Edge 2023.1
     */
    void onOutboundPublish(
            @NotNull BridgePublishOutboundInput publishOutboundInput, @NotNull BridgePublishOutboundOutput publishOutboundOutput);
}
