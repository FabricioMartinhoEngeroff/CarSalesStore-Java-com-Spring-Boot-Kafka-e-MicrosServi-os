package com.store.carSalesStore.service;

import com.store.carSalesStore.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void newPostDetails(CarPostDTO carPostDTO);

    List<CarPostDTO> getCarSales();

    void changeCarSales(CarPostDTO carPostDTO, Long postId);

    void removeCarSale(Long postId);
}
