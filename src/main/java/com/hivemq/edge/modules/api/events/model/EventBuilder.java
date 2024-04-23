package com.hivemq.edge.modules.api.events.model;

import com.hivemq.api.model.core.Payload;
import com.hivemq.edge.model.TypeIdentifier;

public interface EventBuilder {
    EventBuilder withSeverity(Event.SEVERITY severity);

    EventBuilder withMessage(String message);

    EventBuilder withPayload(Payload payload);

    EventBuilder withTimestamp(Long timestamp);

    EventBuilder withAssociatedObject(TypeIdentifier associatedObject);

    EventBuilder withSource(TypeIdentifier source);

    Event build();
}
