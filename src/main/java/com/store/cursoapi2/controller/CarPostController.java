package com.store.cursoapi2.controller;

import com.store.cursoapi2.dto.CarPostDTO;
import com.store.cursoapi2.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-server-sales")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.ok().body(carPostService.getCarSales());
    }

    @PostMapping("/car/{id}")
    public ResponseEntity changeCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable String id){
        carPostService.changeCarSales(carPostDTO, Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity deleteCarSales(@PathVariable("id") String id){
        carPostService.removeCarSales(Long.parseLong(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
