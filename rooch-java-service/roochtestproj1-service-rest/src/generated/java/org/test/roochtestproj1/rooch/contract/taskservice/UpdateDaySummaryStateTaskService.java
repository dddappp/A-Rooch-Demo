// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.rooch.contract.taskservice;

import org.test.roochtestproj1.rooch.contract.repository.*;
import org.test.roochtestproj1.rooch.contract.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateDaySummaryStateTaskService {

    @Autowired
    private RoochDaySummaryService roochDaySummaryService;

    @Autowired
    private DaySummaryEventRepository daySummaryEventRepository;

    @Autowired
    private DaySummaryEventService daySummaryEventService;

    @Scheduled(fixedDelayString = "${rooch.contract.update-day-summary-states.fixed-delay:5000}")
    @Transactional
    public void updateDaySummaryStates() {
        daySummaryEventRepository.findByStatusIsNull().forEach(e -> {
            String objectId = e.getId_();
            roochDaySummaryService.updateDaySummaryState(objectId);
            daySummaryEventService.updateStatusToProcessed(e);
        });
    }
}
