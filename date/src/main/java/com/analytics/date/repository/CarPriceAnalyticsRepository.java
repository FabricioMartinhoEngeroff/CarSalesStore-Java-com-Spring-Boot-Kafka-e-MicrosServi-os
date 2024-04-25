package com.analytics.date.repository;

import com.analytics.date.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarPriceAnalyticsRepository extends JpaRepository<CarModelPriceEntity, Long> {
     Optional<CarModelPriceEntity>  findByModel(String model);
}
