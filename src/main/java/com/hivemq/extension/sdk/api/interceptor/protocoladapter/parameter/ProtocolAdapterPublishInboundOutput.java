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
import org.jetbrains.annotations.NotNull;
import com.hivemq.extension.sdk.api.async.Async;
import com.hivemq.extension.sdk.api.async.AsyncOutput;
import com.hivemq.extension.sdk.api.async.TimeoutFallback;
import com.hivemq.extension.sdk.api.interceptor.protocoladapter.ProtocolAdapterPublishInboundInterceptor;
import com.hivemq.extension.sdk.api.interceptor.publish.parameter.PublishInboundOutput;
import com.hivemq.extension.sdk.api.packets.publish.ModifiablePublishPacket;

import java.time.Duration;

/**
 * This is the output parameter of any {@link ProtocolAdapterPublishInboundInterceptor} providing methods to define the outcome of
 * PUBLISH interception.
 * <p>
 * It can be used to
 * <ul>
 *   <li>Modify an inbound PUBLISH packet
 *   <li>Prevent delivery of an inbound PUBLISH packet
 * </ul>
 * <p>
 * Only one of the methods {@link #preventPublishDelivery()} may be called.
 * <p>
 * Subsequent calls will fail with an {@link UnsupportedOperationException}.
 *
 * @since Edge 2023.1
 */
@DoNotImplement
public interface ProtocolAdapterPublishInboundOutput extends AsyncOutput<ProtocolAdapterPublishInboundOutput> {

    /**
     * Use this object to make any changes to the inbound PUBLISH.
     *
     * @return A modifiable publish packet.
     * @since Edge 2023.1
     */
    @NotNull ModifiablePublishPacket getPublishPacket();

    /**
     * Prevent the onward delivery of the PUBLISH packet
     *
     * @throws UnsupportedOperationException When preventPublishDelivery is called more than once.
     * @since Edge 2023.1
     */
    void preventPublishDelivery();

    /**
     * If the timeout is expired before {@link Async#resume()} is called then the outcome is handled either as failed or
     * successful, depending on the specified fallback.
     * <p>
     * Do not call this method more than once. If an async method is called multiple times an exception is thrown.
     *
     * @param timeout         Timeout that HiveMQ waits for the result of the async operation.
     * @param timeoutFallback Fallback behaviour if a timeout occurs.
     *                        <p>
     *                        If the fallback is SUCCESS then the publish will be delivered.
     *                        <p>
     *                        If the fallback is FAILURE then the publish will be dropped.
     * @return An {@link Async} object, containing the {@link PublishInboundOutput}.
     * @throws UnsupportedOperationException If async is called more than once.
     * @since Edge 2023.1
     */
    @NotNull Async<ProtocolAdapterPublishInboundOutput> async(
            @NotNull Duration timeout,
            @NotNull TimeoutFallback timeoutFallback);


}
