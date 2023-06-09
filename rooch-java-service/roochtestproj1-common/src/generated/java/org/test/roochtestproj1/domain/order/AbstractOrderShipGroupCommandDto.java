// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.order;

import java.util.Date;
import org.test.roochtestproj1.domain.*;
import org.test.roochtestproj1.domain.AbstractCommand;

public abstract class AbstractOrderShipGroupCommandDto extends AbstractCommand {

    /**
     * Ship Group Seq Id
     */
    private Integer shipGroupSeqId;

    public Integer getShipGroupSeqId()
    {
        return this.shipGroupSeqId;
    }

    public void setShipGroupSeqId(Integer shipGroupSeqId)
    {
        this.shipGroupSeqId = shipGroupSeqId;
    }


    public void copyTo(OrderShipGroupCommand command) {
        command.setShipGroupSeqId(this.getShipGroupSeqId());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
