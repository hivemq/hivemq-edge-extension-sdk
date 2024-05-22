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
package com.hivemq.extension.sdk.api.adapters.config;

import com.hivemq.extension.sdk.api.annotations.NotNull;

/**
 * Marker Interface for the config of Protocol Adapters.
 *
 */

public interface ProtocolAdapterConfig {

    String ID_REGEX = "^([a-zA-Z_0-9-_])*$";

    int PORT_MIN = 1;
    int PORT_MAX = 65535;

    @NotNull String getId();
}
