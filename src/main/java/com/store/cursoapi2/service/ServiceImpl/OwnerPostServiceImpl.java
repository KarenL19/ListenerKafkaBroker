package com.store.cursoapi2.service.ServiceImpl;

import com.store.cursoapi2.dto.OwnerPostDTO;
import com.store.cursoapi2.entity.OwnerPostEntity;
import com.store.cursoapi2.repository.OwnerPostRepository;
import com.store.cursoapi2.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {
    @Autowired
    private OwnerPostRepository ownerPostRepository;
    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        OwnerPostEntity ownerPostEntity = new OwnerPostEntity();
        ownerPostEntity.setName(ownerPostDTO.getName());
        ownerPostEntity.setType(ownerPostDTO.getType());
        ownerPostEntity.setContactNumber(ownerPostDTO.getContactNumber());

        ownerPostRepository.save(ownerPostEntity);

    }
}
