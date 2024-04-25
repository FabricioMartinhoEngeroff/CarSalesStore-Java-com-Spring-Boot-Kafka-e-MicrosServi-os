package com.store.carSalesStore.contoller;

import com.store.carSalesStore.dto.OwnerPostDTO;
import com.store.carSalesStore.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity createdOwnerPost(@RequestBody OwnerPostDTO ownerPostDTO){
        ownerPostService.createdOwnerPost(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
