// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.order;

import java.util.*;
import java.math.*;
import java.util.Date;
import org.test.roochtestproj1.domain.*;
import org.test.roochtestproj1.specialization.Event;

public interface OrderItemShipGroupAssociationState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getProductObjId();

    BigInteger getQuantity();

    BigInteger getCancelQuantity();

    Long getOffChainVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    String getOrderId();

    Integer getOrderShipGroupShipGroupSeqId();

    EntityStateCollection<Day, OrderItemShipGroupAssocSubitemState> getSubitems();

    interface MutableOrderItemShipGroupAssociationState extends OrderItemShipGroupAssociationState {
        void setProductObjId(String productObjId);

        void setQuantity(BigInteger quantity);

        void setCancelQuantity(BigInteger cancelQuantity);

        void setOffChainVersion(Long offChainVersion);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);

        void setOrderId(String orderId);

        void setOrderShipGroupShipGroupSeqId(Integer orderShipGroupShipGroupSeqId);


        void mutate(Event e);

        //void when(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateCreated e);

        //void when(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateMergePatched e);

        //void when(OrderItemShipGroupAssociationEvent.OrderItemShipGroupAssociationStateRemoved e);
    }

    interface SqlOrderItemShipGroupAssociationState extends MutableOrderItemShipGroupAssociationState {
        OrderItemShipGroupAssociationId getOrderItemShipGroupAssociationId();

        void setOrderItemShipGroupAssociationId(OrderItemShipGroupAssociationId orderItemShipGroupAssociationId);


        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

