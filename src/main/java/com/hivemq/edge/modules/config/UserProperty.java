package com.hivemq.edge.modules.config;

public interface UserProperty {
    String getPropertyName();

    void setPropertyName(String propertyName);

    String getPropertyValue();

    void setPropertyValue(String propertyValue);
}
