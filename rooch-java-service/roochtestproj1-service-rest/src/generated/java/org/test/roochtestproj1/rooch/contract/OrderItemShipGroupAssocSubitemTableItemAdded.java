// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.rooch.contract;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.wubuku.rooch.bean.*;

import java.math.*;
import java.util.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderItemShipGroupAssocSubitemTableItemAdded {

    private String orderId;

    private Integer orderShipGroupShipGroupSeqId;

    private String orderItemShipGroupAssociationProductObjId;

    private Day orderItemShipGroupAssocSubitemDay;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderShipGroupShipGroupSeqId() {
        return orderShipGroupShipGroupSeqId;
    }

    public void setOrderShipGroupShipGroupSeqId(Integer orderShipGroupShipGroupSeqId) {
        this.orderShipGroupShipGroupSeqId = orderShipGroupShipGroupSeqId;
    }

    public String getOrderItemShipGroupAssociationProductObjId() {
        return orderItemShipGroupAssociationProductObjId;
    }

    public void setOrderItemShipGroupAssociationProductObjId(String orderItemShipGroupAssociationProductObjId) {
        this.orderItemShipGroupAssociationProductObjId = orderItemShipGroupAssociationProductObjId;
    }

    public Day getOrderItemShipGroupAssocSubitemDay() {
        return orderItemShipGroupAssocSubitemDay;
    }

    public void setOrderItemShipGroupAssocSubitemDay(Day orderItemShipGroupAssocSubitemDay) {
        this.orderItemShipGroupAssocSubitemDay = orderItemShipGroupAssocSubitemDay;
    }

    @Override
    public String toString() {
        return "OrderItemShipGroupAssocSubitemTableItemAdded{" +
                "orderId=" + '\'' + orderId + '\'' +
                ", orderShipGroupShipGroupSeqId=" + orderShipGroupShipGroupSeqId +
                ", orderItemShipGroupAssociationProductObjId=" + '\'' + orderItemShipGroupAssociationProductObjId + '\'' +
                ", orderItemShipGroupAssocSubitemDay=" + orderItemShipGroupAssocSubitemDay +
                '}';
    }
    
}

