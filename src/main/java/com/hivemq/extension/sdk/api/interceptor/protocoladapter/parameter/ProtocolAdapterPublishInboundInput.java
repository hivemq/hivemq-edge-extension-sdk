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
package com.hivemq.extension.sdk.api.interceptor.protocoladapter.parameter;

import com.hivemq.extension.sdk.api.annotations.DoNotImplement;
import com.hivemq.extension.sdk.api.annotations.Immutable;
import org.jetbrains.annotations.NotNull;
import com.hivemq.extension.sdk.api.interceptor.protocoladapter.ProtocolAdapterPublishInboundInterceptor;
import com.hivemq.extension.sdk.api.packets.publish.PublishPacket;

/**
 * This is the input parameter of any {@link ProtocolAdapterPublishInboundInterceptor} providing the PUBLISH and protocol adapter based
 * information.
 *
 * @since Edge 2023.1
 */
@DoNotImplement
public interface ProtocolAdapterPublishInboundInput {

    /**
     * The unmodifiable PUBLISH packet that was intercepted.
     *
     * @return An unmodifiable {@link PublishPacket}.
     * @since Edge 2023.1
     */
    @Immutable @NotNull PublishPacket getPublishPacket();

    @Immutable @NotNull ProtocolAdapterInformation getProtocolAdapterInformation();

    @Immutable @NotNull ProtocolAdapterDynamicContext getProtocolAdapterDynamicContext();
}
