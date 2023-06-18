// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.rooch.contract.persistence;

import org.test.roochtestproj1.domain.RoochEvent;
import org.test.roochtestproj1.domain.RoochEventId;
import org.test.roochtestproj1.domain.order.*;

import java.math.*;
import java.util.*;

public class OrderItemTableItemAdded implements RoochEvent, RoochEvent.MutableRoochEvent {
    private OrderItemId orderItemId;

    public OrderItemId getOrderItemId() {
        return this.orderItemId;
    }

    public void setOrderItemId(OrderItemId orderItemId) {
        this.orderItemId = orderItemId;
    }

    private RoochEventId roochEventId;

    public RoochEventId getRoochEventId() {
        return this.roochEventId;
    }

    public void setRoochEventId(RoochEventId roochEventId) {
        this.roochEventId = roochEventId;
    }

    private String roochSender;

    public String getRoochSender() {
        return this.roochSender;
    }

    public void setRoochSender(String roochSender) {
        this.roochSender = roochSender;
    }

    private String roochTxHash;

    public String getRoochTxHash() {
        return this.roochTxHash;
    }

    public void setRoochTxHash(String roochTxHash) {
        this.roochTxHash = roochTxHash;
    }

    private String roochTypeTag;

    public String getRoochTypeTag() {
        return this.roochTypeTag;
    }

    public void setRoochTypeTag(String roochTypeTag) {
        this.roochTypeTag = roochTypeTag;
    }

    private Long roochTimestampMs;

    public Long getRoochTimestampMs() {
        return this.roochTimestampMs;
    }

    public void setRoochTimestampMs(Long roochTimestampMs) {
        this.roochTimestampMs = roochTimestampMs;
    }

    private BigInteger roochBlockHeight;

    public BigInteger getRoochBlockHeight() {
        return this.roochBlockHeight;
    }

    public void setRoochBlockHeight(BigInteger roochBlockHeight) {
        this.roochBlockHeight = roochBlockHeight;
    }

    private Long roochEventIndex;

    public Long getRoochEventIndex() {
        return this.roochEventIndex;
    }

    public void setRoochEventIndex(Long roochEventIndex) {
        this.roochEventIndex = roochEventIndex;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    private Boolean deleted;

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "OrderItemTableItemAdded{" +
                "orderItemId=" + orderItemId +
                ", roochEventId=" + roochEventId +
                ", roochSender=" + '\'' + roochSender + '\'' +
                ", roochTxHash=" + '\'' + roochTxHash + '\'' +
                ", roochTypeTag=" + '\'' + roochTypeTag + '\'' +
                ", roochTimestampMs=" + roochTimestampMs +
                ", roochBlockHeight=" + roochBlockHeight +
                ", roochEventIndex=" + roochEventIndex +
                ", createdBy=" + '\'' + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedBy=" + '\'' + updatedBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", deleted=" + deleted +
                '}';
    }
    
}

