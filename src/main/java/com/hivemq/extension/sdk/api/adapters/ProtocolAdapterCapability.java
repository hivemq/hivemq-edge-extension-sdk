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

/**
 * @author Simon L Johnson
 */
public enum ProtocolAdapterCapability {

    /**
     * can the adapter-type read values from the external source and publish them into the system
     **/
     READ,

    /**
     * can the adapter-type write values from the local broker publish them into the system
     **/
     WRITE,

    /**
     * can the adapter-type discover tags/names from the external source
     **/
     DISCOVER;
}
