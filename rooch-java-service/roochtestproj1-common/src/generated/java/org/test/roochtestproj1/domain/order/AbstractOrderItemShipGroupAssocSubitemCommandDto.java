// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.order;

import org.test.roochtestproj1.domain.*;
import java.util.Date;
import org.test.roochtestproj1.domain.AbstractCommand;

public abstract class AbstractOrderItemShipGroupAssocSubitemCommandDto extends AbstractCommand {

    /**
     * Order Item Ship Group Assoc Subitem Day
     */
    private Day orderItemShipGroupAssocSubitemDay;

    public Day getOrderItemShipGroupAssocSubitemDay()
    {
        return this.orderItemShipGroupAssocSubitemDay;
    }

    public void setOrderItemShipGroupAssocSubitemDay(Day orderItemShipGroupAssocSubitemDay)
    {
        this.orderItemShipGroupAssocSubitemDay = orderItemShipGroupAssocSubitemDay;
    }


    public void copyTo(OrderItemShipGroupAssocSubitemCommand command) {
        command.setOrderItemShipGroupAssocSubitemDay(this.getOrderItemShipGroupAssocSubitemDay());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
