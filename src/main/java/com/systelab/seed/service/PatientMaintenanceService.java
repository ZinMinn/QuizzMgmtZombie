package com.systelab.seed.service;

import com.systelab.seed.config.health.PatientMaintenanceServiceHealthIndicator;
import com.systelab.seed.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PatientMaintenanceService {

    private Logger logger = LoggerFactory.getLogger(PatientMaintenanceService.class);

    private final PatientRepository patientRepository;

    private final PatientMaintenanceServiceHealthIndicator healthIndicator;

    @Autowired
    public PatientMaintenanceService(PatientRepository patientRepository, PatientMaintenanceServiceHealthIndicator healthIndicator) {
        this.patientRepository = patientRepository;
        this.healthIndicator = healthIndicator;
    }

    @Scheduled(cron = "${patient.maintenance.cron.expression}")
    public void schedulePurgeOlderRecordsTask() {
        try {
            this.patientRepository.setActiveForUpdatedBefore(LocalDateTime.now().minusYears(1));
            logger.info("Patients DB purged!");
            healthIndicator.setWorking(true);
            healthIndicator.setLastExecution(LocalDateTime.now());
        } catch (Exception ex) {
            logger.error("Patients DB not purged!", ex);
            healthIndicator.setWorking(false);
        }
    }
}