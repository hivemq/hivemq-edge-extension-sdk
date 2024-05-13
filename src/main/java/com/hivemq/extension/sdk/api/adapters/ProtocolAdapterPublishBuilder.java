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

import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.mqtt.PublishReturnCode;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public interface ProtocolAdapterPublishBuilder {

    /**
     * @param mqttTopic the mqtt topic of the publish
     * @return the builder for fluent API
     */
    @NotNull ProtocolAdapterPublishBuilder withTopic(@NotNull String mqttTopic);

    /**
     *
     * @param payload the payload of the publish
     * @return the builder for fluent API
     */
    @NotNull ProtocolAdapterPublishBuilder withPayload(byte @NotNull [] payload);

    /**
     *
     * @param qos the qos of the publish
     * @return the builder for fluent API
     */
    @NotNull ProtocolAdapterPublishBuilder withQoS(int qos);

    /**
     *
     * @param messageExpiryInterval the message expiry of the publish
     * @return the builder for fluent API
     */
    @NotNull ProtocolAdapterPublishBuilder withMessageExpiryInterval(long messageExpiryInterval);

    /**
     * Adds a user property to the publisj
     * @param name the name of the user property
     * @param value the value of the user property
     * @return the builder for fluent API
     */
    @NotNull ProtocolAdapterPublishBuilder withUserProperty(@NotNull String name, @NotNull String value);

    /**
     *
     * @param retained true: message gets published as a retained message, false: message gets published as a normal publish
     * @return the builder for fluent API
     */
    @NotNull ProtocolAdapterPublishBuilder withRetain(boolean retained);

    /**
     * Adds additional information to the publish
     * @param key the key of the additional information
     * @param value the value of the additional information
     * @return the builder for fluent API
     */
    @NotNull ProtocolAdapterPublishBuilder withContextInformation(@NotNull String key, @NotNull String value);

    /**
     *
     * @param adapter the adapter for which the publish gets created.
     * @return the builder for fluent API
     */
    @NotNull ProtocolAdapterPublishBuilder withAdapter(@NotNull ProtocolAdapter adapter);

    /**
     * Sends the publish to the edge for publishing
     * @return the builder for fluent API
     */
    @NotNull CompletableFuture<PublishReturnCode> send();


}
