package com.store.cursoapi2.repository;

import com.store.cursoapi2.entity.CarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity,Long> {
}
