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
package com.hivemq.extension.sdk.api.events;

import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.annotations.Nullable;
import com.hivemq.extension.sdk.api.events.model.Event;

import java.util.List;

/**
 * @author Simon L Johnson
 */
public interface EventService {

    /**
     * @param event the Event that gets published on the event service
     */
    void fireEvent(final @NotNull Event event);

    /**
     * @param sinceTimestamp events before this timestamp will not be returned.
     * @param limit how many events should be fetched
     * @return a sorted list of events from latest events to older events.
     */
    @NotNull List<Event> readEvents(final @Nullable Long sinceTimestamp, final @Nullable Integer limit);


}
