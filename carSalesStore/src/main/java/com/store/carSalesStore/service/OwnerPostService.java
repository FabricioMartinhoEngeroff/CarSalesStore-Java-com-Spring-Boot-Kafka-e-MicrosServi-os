package com.store.carSalesStore.service;

import com.store.carSalesStore.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createdOwnerPost(OwnerPostDTO ownerPostDTO);
}

