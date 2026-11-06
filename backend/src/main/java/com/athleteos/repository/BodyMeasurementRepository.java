package com.athleteos.repository;

import com.athleteos.model.BodyMeasurement;
import com.athleteos.model.Message;
import com.athleteos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BodyMeasurementRepository extends JpaRepository<BodyMeasurement,UUID> {

    List<BodyMeasurement> findByUserOrderByDatumDesc(User user);
}
