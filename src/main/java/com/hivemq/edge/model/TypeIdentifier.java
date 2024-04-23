package com.hivemq.edge.model;

public interface TypeIdentifier {

    public enum TYPE {
        BRIDGE, ADAPTER, ADAPTER_TYPE, EVENT, USER
    }

    TypeIdentifier.TYPE getType();

    String getIdentifier();

    String getFullQualifiedIdentifier();

}
