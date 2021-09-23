package com.rogers.dashboard.model.v1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class CallID {
    private String uuid;
    private String deviceID;
    private String propertyID;

    public CallID() {
        this.uuid = UUID.randomUUID().toString();
    }

    public CallID(String deviceID, String propertyID) {
        this.uuid = UUID.randomUUID().toString();
        this.deviceID = deviceID;
        this.propertyID = propertyID;
    }

    public CallID(String uuid, String deviceID, String propertyID) {
        this.uuid = uuid;
        this.deviceID = deviceID;
        this.propertyID = propertyID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CallID callID = (CallID) o;

        return new EqualsBuilder()
                .append(uuid, callID.uuid)
                .append(deviceID, callID.deviceID)
                .append(propertyID, callID.propertyID)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(uuid)
                .append(deviceID)
                .append(propertyID)
                .toHashCode();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    @Override
    public String toString() {
        return deviceID != null ? uuid + "_" + deviceID + "_" + propertyID : uuid;
    }
}
