package com.hivemq.edge.modules.api.events.model;

import com.hivemq.api.model.core.Payload;
import com.hivemq.edge.model.TypeIdentifier;

public class EventBuilder {
    private Event.SEVERITY severity;
    private String message;
    private Payload payload;
    private Long timestamp;
    private TypeIdentifier associatedObject;
    private TypeIdentifier source;

    public EventBuilder withSeverity(final Event.SEVERITY severity) {
        this.severity = severity;
        return this;
    }

    public EventBuilder withMessage(final String message) {
        this.message = message;
        return this;
    }

    public EventBuilder withPayload(final Payload payload) {
        this.payload = payload;
        return this;
    }

    public EventBuilder withTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public EventBuilder withAssociatedObject(final TypeIdentifier associatedObject) {
        this.associatedObject = associatedObject;
        return this;
    }

    public EventBuilder withSource(final TypeIdentifier source) {
        this.source = source;
        return this;
    }

    public Event build() {
        return new Event(TypeIdentifier.generate(TypeIdentifier.TYPE.EVENT),
                severity,
                message,
                payload,
                timestamp,
                associatedObject,
                source);
    }
}
