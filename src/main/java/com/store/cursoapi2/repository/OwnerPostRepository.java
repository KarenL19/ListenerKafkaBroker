package com.store.cursoapi2.repository;

import com.store.cursoapi2.entity.OwnerPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity,Long> {
}
