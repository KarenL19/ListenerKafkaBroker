package com.store.cursoapi2.service;

import com.store.cursoapi2.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {
    void newPostDetails(CarPostDTO carPostDTO);
    List<CarPostDTO> getCarSales();
    void changeCarSales(CarPostDTO carPostDTO, Long id);
    void removeCarSales(Long id);
}
