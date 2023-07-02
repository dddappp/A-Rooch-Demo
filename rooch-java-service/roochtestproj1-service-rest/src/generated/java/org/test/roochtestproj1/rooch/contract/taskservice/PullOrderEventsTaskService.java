// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.rooch.contract.taskservice;

import org.test.roochtestproj1.rooch.contract.service.OrderEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PullOrderEventsTaskService {

    @Autowired
    private OrderEventService orderEventService;

    @Scheduled(fixedDelayString = "${rooch.contract.pull-order-events.order-created.fixed-delay:5000}")
    public void pullOrderCreatedEvents() {
        orderEventService.pullOrderCreatedEvents();
    }

    @Scheduled(fixedDelayString = "${rooch.contract.pull-order-events.order-item-removed.fixed-delay:5000}")
    public void pullOrderItemRemovedEvents() {
        orderEventService.pullOrderItemRemovedEvents();
    }

    @Scheduled(fixedDelayString = "${rooch.contract.pull-order-events.order-item-quantity-updated.fixed-delay:5000}")
    public void pullOrderItemQuantityUpdatedEvents() {
        orderEventService.pullOrderItemQuantityUpdatedEvents();
    }

    @Scheduled(fixedDelayString = "${rooch.contract.pull-order-events.order-estimated-ship-date-updated.fixed-delay:5000}")
    public void pullOrderEstimatedShipDateUpdatedEvents() {
        orderEventService.pullOrderEstimatedShipDateUpdatedEvents();
    }

    @Scheduled(fixedDelayString = "${rooch.contract.pull-order-events.order-ship-group-added.fixed-delay:5000}")
    public void pullOrderShipGroupAddedEvents() {
        orderEventService.pullOrderShipGroupAddedEvents();
    }

    @Scheduled(fixedDelayString = "${rooch.contract.pull-order-events.order-item-ship-group-assoc-subitem-added.fixed-delay:5000}")
    public void pullOrderItemShipGroupAssocSubitemAddedEvents() {
        orderEventService.pullOrderItemShipGroupAssocSubitemAddedEvents();
    }

    @Scheduled(fixedDelayString = "${rooch.contract.pull-order-events.order-ship-group-quantity-canceled.fixed-delay:5000}")
    public void pullOrderShipGroupQuantityCanceledEvents() {
        orderEventService.pullOrderShipGroupQuantityCanceledEvents();
    }

    @Scheduled(fixedDelayString = "${rooch.contract.pull-order-events.order-ship-group-item-removed.fixed-delay:5000}")
    public void pullOrderShipGroupItemRemovedEvents() {
        orderEventService.pullOrderShipGroupItemRemovedEvents();
    }

}
