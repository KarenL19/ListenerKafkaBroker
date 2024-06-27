package com.store.cursoapi2.service;

import com.store.cursoapi2.dto.OwnerPostDTO;
import org.springframework.stereotype.Component;

@Component
public interface OwnerPostService {
    void createOwnerPost(OwnerPostDTO ownerPostDTO);
}
