// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.order;

import java.util.*;
import java.math.*;
import org.test.roochtestproj1.domain.*;
import java.util.Date;
import org.test.roochtestproj1.specialization.*;
import org.test.roochtestproj1.domain.order.OrderItemShipGroupAssocSubitemEvent.*;

public abstract class AbstractOrderItemShipGroupAssocSubitemState implements OrderItemShipGroupAssocSubitemState.SqlOrderItemShipGroupAssocSubitemState {

    private OrderItemShipGroupAssocSubitemId orderItemShipGroupAssocSubitemId = new OrderItemShipGroupAssocSubitemId();

    public OrderItemShipGroupAssocSubitemId getOrderItemShipGroupAssocSubitemId() {
        return this.orderItemShipGroupAssocSubitemId;
    }

    public void setOrderItemShipGroupAssocSubitemId(OrderItemShipGroupAssocSubitemId orderItemShipGroupAssocSubitemId) {
        this.orderItemShipGroupAssocSubitemId = orderItemShipGroupAssocSubitemId;
    }

    private transient OrderState orderState;

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState s) {
        orderState = s;
    }
    
    private OrderItemShipGroupAssociationState protectedOrderItemShipGroupAssociationState;

    protected OrderItemShipGroupAssociationState getProtectedOrderItemShipGroupAssociationState() {
        return protectedOrderItemShipGroupAssociationState;
    }

    protected void setProtectedOrderItemShipGroupAssociationState(OrderItemShipGroupAssociationState protectedOrderItemShipGroupAssociationState) {
        this.protectedOrderItemShipGroupAssociationState = protectedOrderItemShipGroupAssociationState;
    }

    public String getOrderId() {
        return this.getOrderItemShipGroupAssocSubitemId().getOrderId();
    }
        
    public void setOrderId(String orderId) {
        this.getOrderItemShipGroupAssocSubitemId().setOrderId(orderId);
    }

    public Integer getOrderShipGroupShipGroupSeqId() {
        return this.getOrderItemShipGroupAssocSubitemId().getOrderShipGroupShipGroupSeqId();
    }
        
    public void setOrderShipGroupShipGroupSeqId(Integer orderShipGroupShipGroupSeqId) {
        this.getOrderItemShipGroupAssocSubitemId().setOrderShipGroupShipGroupSeqId(orderShipGroupShipGroupSeqId);
    }

    public String getOrderItemShipGroupAssociationProductObjId() {
        return this.getOrderItemShipGroupAssocSubitemId().getOrderItemShipGroupAssociationProductObjId();
    }
        
    public void setOrderItemShipGroupAssociationProductObjId(String orderItemShipGroupAssociationProductObjId) {
        this.getOrderItemShipGroupAssocSubitemId().setOrderItemShipGroupAssociationProductObjId(orderItemShipGroupAssociationProductObjId);
    }

    public Day getOrderItemShipGroupAssocSubitemDay() {
        return this.getOrderItemShipGroupAssocSubitemId().getOrderItemShipGroupAssocSubitemDay();
    }
        
    public void setOrderItemShipGroupAssocSubitemDay(Day orderItemShipGroupAssocSubitemDay) {
        this.getOrderItemShipGroupAssocSubitemId().setOrderItemShipGroupAssocSubitemDay(orderItemShipGroupAssocSubitemDay);
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Long offChainVersion;

    public Long getOffChainVersion() {
        return this.offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion) {
        this.offChainVersion = offChainVersion;
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

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private Boolean deleted;

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isStateUnsaved() {
        return this.getOffChainVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }


    public AbstractOrderItemShipGroupAssocSubitemState() {
        initializeProperties();
    }

    protected void initializeForReapplying() {
        this.forReapplying = true;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getOrderItemShipGroupAssocSubitemDay().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj instanceof OrderItemShipGroupAssocSubitemState) {
            return Objects.equals(this.getOrderItemShipGroupAssocSubitemDay(), ((OrderItemShipGroupAssocSubitemState)obj).getOrderItemShipGroupAssocSubitemDay());
        }
        return false;
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (false) { 
            ;
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    protected void merge(OrderItemShipGroupAssocSubitemState s) {
        if (s == this) {
            return;
        }
        this.setDescription(s.getDescription());
        this.setActive(s.getActive());
    }

    public void save() {
    }

    protected void throwOnWrongEvent(OrderItemShipGroupAssocSubitemEvent event) {
        String stateEntityIdOrderId = this.getOrderItemShipGroupAssocSubitemId().getOrderId();
        String eventEntityIdOrderId = ((OrderItemShipGroupAssocSubitemEvent.SqlOrderItemShipGroupAssocSubitemEvent)event).getOrderItemShipGroupAssocSubitemEventId().getOrderId();
        if (!stateEntityIdOrderId.equals(eventEntityIdOrderId)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id OrderId %1$s in state but entity id OrderId %2$s in event", stateEntityIdOrderId, eventEntityIdOrderId);
        }

        Integer stateEntityIdOrderShipGroupShipGroupSeqId = this.getOrderItemShipGroupAssocSubitemId().getOrderShipGroupShipGroupSeqId();
        Integer eventEntityIdOrderShipGroupShipGroupSeqId = ((OrderItemShipGroupAssocSubitemEvent.SqlOrderItemShipGroupAssocSubitemEvent)event).getOrderItemShipGroupAssocSubitemEventId().getOrderShipGroupShipGroupSeqId();
        if (!stateEntityIdOrderShipGroupShipGroupSeqId.equals(eventEntityIdOrderShipGroupShipGroupSeqId)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id OrderShipGroupShipGroupSeqId %1$s in state but entity id OrderShipGroupShipGroupSeqId %2$s in event", stateEntityIdOrderShipGroupShipGroupSeqId, eventEntityIdOrderShipGroupShipGroupSeqId);
        }

        String stateEntityIdOrderItemShipGroupAssociationProductObjId = this.getOrderItemShipGroupAssocSubitemId().getOrderItemShipGroupAssociationProductObjId();
        String eventEntityIdOrderItemShipGroupAssociationProductObjId = ((OrderItemShipGroupAssocSubitemEvent.SqlOrderItemShipGroupAssocSubitemEvent)event).getOrderItemShipGroupAssocSubitemEventId().getOrderItemShipGroupAssociationProductObjId();
        if (!stateEntityIdOrderItemShipGroupAssociationProductObjId.equals(eventEntityIdOrderItemShipGroupAssociationProductObjId)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id OrderItemShipGroupAssociationProductObjId %1$s in state but entity id OrderItemShipGroupAssociationProductObjId %2$s in event", stateEntityIdOrderItemShipGroupAssociationProductObjId, eventEntityIdOrderItemShipGroupAssociationProductObjId);
        }

        Day stateEntityIdOrderItemShipGroupAssocSubitemDay = this.getOrderItemShipGroupAssocSubitemId().getOrderItemShipGroupAssocSubitemDay();
        Day eventEntityIdOrderItemShipGroupAssocSubitemDay = ((OrderItemShipGroupAssocSubitemEvent.SqlOrderItemShipGroupAssocSubitemEvent)event).getOrderItemShipGroupAssocSubitemEventId().getOrderItemShipGroupAssocSubitemDay();
        if (!stateEntityIdOrderItemShipGroupAssocSubitemDay.equals(eventEntityIdOrderItemShipGroupAssocSubitemDay)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id OrderItemShipGroupAssocSubitemDay %1$s in state but entity id OrderItemShipGroupAssocSubitemDay %2$s in event", stateEntityIdOrderItemShipGroupAssocSubitemDay, eventEntityIdOrderItemShipGroupAssocSubitemDay);
        }


        if (getForReapplying()) { return; }

    }


    public static class SimpleOrderItemShipGroupAssocSubitemState extends AbstractOrderItemShipGroupAssocSubitemState {

        public SimpleOrderItemShipGroupAssocSubitemState() {
        }

        public static SimpleOrderItemShipGroupAssocSubitemState newForReapplying() {
            SimpleOrderItemShipGroupAssocSubitemState s = new SimpleOrderItemShipGroupAssocSubitemState();
            s.initializeForReapplying();
            return s;
        }

    }



}

