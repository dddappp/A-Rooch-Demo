// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.order;

import java.util.*;
import org.test.roochtestproj1.domain.*;
import java.util.Date;
import org.test.roochtestproj1.specialization.*;
import org.test.roochtestproj1.domain.AbstractEvent;

public abstract class AbstractOrderItemShipGroupAssocSubitemEvent extends AbstractEvent implements OrderItemShipGroupAssocSubitemEvent.SqlOrderItemShipGroupAssocSubitemEvent, RoochEvent.MutableRoochEvent, HasStatus.MutableHasStatus {
    private OrderItemShipGroupAssocSubitemEventId orderItemShipGroupAssocSubitemEventId = new OrderItemShipGroupAssocSubitemEventId();

    public OrderItemShipGroupAssocSubitemEventId getOrderItemShipGroupAssocSubitemEventId() {
        return this.orderItemShipGroupAssocSubitemEventId;
    }

    public void setOrderItemShipGroupAssocSubitemEventId(OrderItemShipGroupAssocSubitemEventId eventId) {
        this.orderItemShipGroupAssocSubitemEventId = eventId;
    }
    
    public Day getOrderItemShipGroupAssocSubitemDay() {
        return getOrderItemShipGroupAssocSubitemEventId().getOrderItemShipGroupAssocSubitemDay();
    }

    public void setOrderItemShipGroupAssocSubitemDay(Day orderItemShipGroupAssocSubitemDay) {
        getOrderItemShipGroupAssocSubitemEventId().setOrderItemShipGroupAssocSubitemDay(orderItemShipGroupAssocSubitemDay);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    protected AbstractOrderItemShipGroupAssocSubitemEvent() {
    }

    protected AbstractOrderItemShipGroupAssocSubitemEvent(OrderItemShipGroupAssocSubitemEventId eventId) {
        this.orderItemShipGroupAssocSubitemEventId = eventId;
    }


    public abstract String getEventType();


}

