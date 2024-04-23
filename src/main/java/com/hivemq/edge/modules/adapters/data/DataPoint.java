package com.hivemq.edge.modules.adapters.data;

public interface DataPoint {
    Object getTagValue();

    String getTagName();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
