// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.rooch.contract.repository;

import org.test.roochtestproj1.domain.tag.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface TagEventRepository extends JpaRepository<AbstractTagEvent, TagEventId> {

    List<AbstractTagEvent> findByStatusIsNull();

    AbstractTagEvent.TagCreated findFirstTagCreatedByOrderByRoochEventId_EventSeqDesc();

}
