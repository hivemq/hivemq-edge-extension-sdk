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
import com.hivemq.extension.sdk.api.interceptor.bridge.parameter.BridgePublishInboundInput;
import com.hivemq.extension.sdk.api.interceptor.bridge.parameter.BridgePublishInboundOutput;

/**
 * Interface for the publish inbound interception.
 * <p>
 * If the same instance is shared between multiple bridges it can be called in different Threads and must therefore be
 * thread-safe.
 * <p>
 *
 * @since Edge 2023.1
 */
public interface BridgePublishInboundInterceptor {

    /**
     * When a {@link BridgePublishInboundInterceptor} is set through any extension, this method gets called for every
     * inbound PUBLISH packet that originates from any remote subscription from any MQTT bridge.
     * <p>
     * When the extension is enabled after HiveMQ is already running, this method will also be called for future
     * PUBLISHes of clients that are already connected.
     *
     * @param publishInboundInput  The {@link BridgePublishInboundInput} parameter.
     * @param publishInboundOutput The {@link BridgePublishInboundOutput} parameter.
     * @since Edge 2023.1
     */
    void onInboundPublish(
            @NotNull BridgePublishInboundInput publishInboundInput,
            @NotNull BridgePublishInboundOutput publishInboundOutput);
}
