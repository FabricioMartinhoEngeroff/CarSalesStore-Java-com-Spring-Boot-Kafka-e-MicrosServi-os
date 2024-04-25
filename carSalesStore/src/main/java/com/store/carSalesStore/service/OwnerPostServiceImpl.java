package com.store.carSalesStore.service;

import com.store.carSalesStore.dto.OwnerPostDTO;
import com.store.carSalesStore.entity.OwnerPostEntity;
import com.store.carSalesStore.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService{

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createdOwnerPost(OwnerPostDTO ownerPostDTO) {
        OwnerPostEntity ownerPost = new OwnerPostEntity();
        ownerPost.setName(ownerPostDTO.getName());
        ownerPost.setType(ownerPostDTO.getType());
        ownerPost.setContractNumber(ownerPostDTO.getContractNumber());

        ownerPostRepository.save(ownerPost);
    }
}
