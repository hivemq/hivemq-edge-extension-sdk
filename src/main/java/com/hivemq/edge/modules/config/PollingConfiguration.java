package com.hivemq.edge.modules.config;

public interface PollingConfiguration {

    long getPollingIntervalInMilliseconds();

    int getMaxPollingErrorsBeforeRemoval();
}
