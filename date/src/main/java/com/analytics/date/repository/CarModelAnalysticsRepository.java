package com.analytics.date.repository;

import com.analytics.date.entity.CarModelAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelAnalysticsRepository extends JpaRepository<CarModelAnalyticsEntity, Long>{
       Optional<CarModelAnalyticsEntity> findByModel(String model);

}
