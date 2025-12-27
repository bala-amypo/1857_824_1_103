package com.example.demo.repository;

import com.example.demo.model.GeneratedShiftSchedule;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneratedShiftScheduleRepository extends JpaRepository<GeneratedShiftSchedule, Long> {

    List<GeneratedShiftSchedule> findByShiftDate(LocalDate shiftDate);
}
