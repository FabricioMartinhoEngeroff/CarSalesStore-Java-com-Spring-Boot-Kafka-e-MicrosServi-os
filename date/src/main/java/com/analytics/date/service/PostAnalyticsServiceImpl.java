package com.analytics.date.service;

import com.analytics.date.dto.CarPostDTO;
import com.analytics.date.entity.BrandAnalyticsEntity;
import com.analytics.date.entity.CarModelAnalyticsEntity;
import com.analytics.date.entity.CarModelPriceEntity;
import com.analytics.date.repository.BrandAnalyticsRepository;
import com.analytics.date.repository.CarModelAnalysticsRepository;
import com.analytics.date.repository.CarPriceAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService {

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalysticsRepository carModelAnalysticsRepository;

    @Autowired
    private CarPriceAnalyticsRepository carPriceAnalyticsRepository;


    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {
        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
        saveModelPriceAnalytics(carPostDTO.getModel(), carPostDTO.getPrice());
    }

    private void saveBrandAnalytics(String brand) {

        BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();


        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            brandAnalyticsRepository.save(item);
        }, () -> {
            brandAnalyticsEntity.setBrand(brand);
            brandAnalyticsEntity.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalyticsEntity);
        });
    }

    private void saveCarModelAnalytics(String carModel) {

        CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();

        carModelAnalysticsRepository.findByModel(carModel).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            carModelAnalysticsRepository.save(item);
        }, () -> {
            carModelAnalyticsEntity.setModel(carModel);
            carModelAnalyticsEntity.setPosts(1L);
            carModelAnalysticsRepository.save(carModelAnalyticsEntity);

        });
    }

    private void saveModelPriceAnalytics(String carModel, Double price) {

        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(carModel);
        carModelPriceEntity.setPrice(price);
        carPriceAnalyticsRepository.save(carModelPriceEntity);

    }

}
