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
package com.hivemq.extension.sdk.api.interceptor.protocoladapter;

import org.jetbrains.annotations.NotNull;
import com.hivemq.extension.sdk.api.interceptor.protocoladapter.parameter.ProtocolAdapterPublishInboundInput;
import com.hivemq.extension.sdk.api.interceptor.protocoladapter.parameter.ProtocolAdapterPublishInboundOutput;

/**
 * Interface for the publish inbound interception.
 * <p>
 * Interceptors are always called by the same Thread for all messages from the same protocol adapter.
 * <p>
 * If the same instance is shared between multiple protocol adapters it can be called in different Threads and must therefore be
 * thread-safe.
 * <p>
 *
 * @since Edge 2023.1
 */
public interface ProtocolAdapterPublishInboundInterceptor {

    /**
     * When a {@link ProtocolAdapterPublishInboundInterceptor} is set through any extension, this method gets called for every
     * inbound PUBLISH packet that originates from any protocol adapter.
     * <p>
     * When the extension is enabled after HiveMQ is already running, this method will also be called for future
     * PUBLISHes of clients that are already connected.
     *
     * @param publishInboundInput  The {@link ProtocolAdapterPublishInboundInput} parameter.
     * @param publishInboundOutput The {@link ProtocolAdapterPublishInboundOutput} parameter.
     * @since Edge 2023.1
     */
    void onInboundPublish(
            @NotNull ProtocolAdapterPublishInboundInput publishInboundInput,
            @NotNull ProtocolAdapterPublishInboundOutput publishInboundOutput);
}
