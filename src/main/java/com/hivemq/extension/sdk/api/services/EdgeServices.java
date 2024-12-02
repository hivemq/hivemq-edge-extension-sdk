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
package com.hivemq.extension.sdk.api.services;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.hivemq.extension.sdk.api.interceptor.bridge.BridgePublishInboundInterceptor;
import com.hivemq.extension.sdk.api.interceptor.bridge.BridgePublishOutboundInterceptor;
import com.hivemq.extension.sdk.api.interceptor.protocoladapter.ProtocolAdapterPublishInboundInterceptor;
import com.hivemq.extension.sdk.api.services.interceptor.EdgeInterceptorRegistry;

import java.util.Map;

public class EdgeServices {

    private static final String NO_ACCESS_MESSAGE =
            "Static class EdgeServices cannot be called from a thread \"%s\" which" +
                    " does not have a HiveMQ extension classloader as its context classloader.";

    //this map is filled by HiveMQ with implementations for all services
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private static @Nullable Map<String, @NotNull Object> edgeServices;

    /**
     * @return A service to set a {@link BridgePublishInboundInterceptor}, {@link BridgePublishOutboundInterceptor} or
     *         {@link ProtocolAdapterPublishInboundInterceptor}.
     * @since Edge 2023.1
     */
    public static @NotNull EdgeInterceptorRegistry edgeInterceptorRegistry() {
        return getClassObject(EdgeInterceptorRegistry.class);
    }

    private static <T> @NotNull T getClassObject(final @NotNull Class<T> clazz) {

        if (edgeServices == null) {
            throw new RuntimeException(String.format(NO_ACCESS_MESSAGE, Thread.currentThread().getName()));
        }

        final Object object = edgeServices.get(clazz.getCanonicalName());
        if (object == null) {
            //don't cache this exception to keep the stacktrace, this is not expected to happen very often
            throw new RuntimeException(String.format(NO_ACCESS_MESSAGE, Thread.currentThread().getName()));
        }
        if (clazz.isInstance(object)) {
            //noinspection unchecked
            return (T) object;
        }
        throw new RuntimeException(String.format(NO_ACCESS_MESSAGE, Thread.currentThread().getName()));
    }
}
