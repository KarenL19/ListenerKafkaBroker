package com.store.cursoapi2.service.ServiceImpl;

import com.store.cursoapi2.dto.CarPostDTO;
import com.store.cursoapi2.entity.CarPostEntity;
import com.store.cursoapi2.entity.OwnerPostEntity;
import com.store.cursoapi2.repository.CarPostRepository;
import com.store.cursoapi2.repository.OwnerPostRepository;
import com.store.cursoapi2.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;
    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);

    }

    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> carPostDTOS = new ArrayList<>();
        carPostRepository.findAll().forEach(item ->{
            carPostDTOS.add(mapCarEntityToDTO(item));
        });
        return carPostDTOS;
    }

    @Override
    public void changeCarSales(CarPostDTO carPostDTO, Long id) {
        carPostRepository.findById(id).ifPresentOrElse(item-> {
            item.setDescription(carPostDTO.getDescription());
            item.setContact(carPostDTO.getContact());
            item.setPrice(carPostDTO.getPrice());
            item.setBrand(carPostDTO.getBrand());
            item.setModel(carPostDTO.getModel());
            item.setEngineVersion(carPostDTO.getEngineVersion());
            carPostRepository.save(item);
        }, ()->{
            throw new RuntimeException("Car post not found");
        });

    }

    @Override
    public void removeCarSales(Long id) {
        carPostRepository.deleteById(id);

    }

    private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity) {
        return CarPostDTO.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createdDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerName())
                .price(carPostEntity.getPrice())
                .build();
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = new CarPostEntity();
        ownerPostRepository.findById(carPostDTO.getOwnerId())
                .ifPresentOrElse(item -> {
                    carPostEntity.setOwnerPost(item);
                    carPostEntity.setContact(item.getContactNumber());
                }, ()->{
                    throw new RuntimeException("Owner post not found");
                });
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setCreatedDate(carPostDTO.getCreatedDate());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setOwnerName(carPostDTO.getOwnerName());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setOwnerType(carPostDTO.getOwnerType());
        carPostEntity.setOwnerId(carPostEntity.getOwnerId());

        return carPostEntity;

    }
}
