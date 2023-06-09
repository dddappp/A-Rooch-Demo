// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.daysummary;

import java.util.*;
import org.test.roochtestproj1.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.test.roochtestproj1.specialization.Event;

public interface DaySummaryEvent extends Event, RoochEvent, HasStatus {

    interface SqlDaySummaryEvent extends DaySummaryEvent {
        DaySummaryEventId getDaySummaryEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    Day getDay();

    //void setDay(Day day);

    BigInteger getVersion();
    
    //void setVersion(BigInteger version);

    String getId_();
    
    //void setId_(String id);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);


}

