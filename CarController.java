package com.example.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicle.entity.CarEntity;
import com.example.vehicle.globalExceptionHandling.DeleteByIdException;
import com.example.vehicle.globalExceptionHandling.IdBrandException;
import com.example.vehicle.globalExceptionHandling.PriceColorException;
import com.example.vehicle.service.CarService;

@RestController
@RequestMapping(value ="/car")


public class CarController {
	@Autowired
	CarService carSer;
	@PostMapping (value ="/insert")
	public String insertValue(@RequestBody CarEntity e) {
		return carSer.insertValue(e);
	}
	@PostMapping (value ="/insertAll")
	public String insertValue1(@RequestBody List<CarEntity> e) {
		return carSer.inserValue1(e);
	}

   @GetMapping(value="/getId/{id}")
   public CarEntity getId(@PathVariable int id) {
	   return carSer.getId(id);
	   
   }
   @GetMapping(value ="/getAll")
   public List<CarEntity> getAll(){
	   return carSer.getAll();
   }
  
   
   @DeleteMapping(value ="/delete/{id}")
   public List<CarEntity> getDelete(@PathVariable int id)throws DeleteByIdException,Exception{
	   return carSer.getDelete(id);
   }
   
   @PutMapping(value="/update/{id}")
   public String getUpdate(@PathVariable CarEntity id) {
	   return carSer.getUpdate(id);
   }
   @GetMapping(value="/getPriceColor/{price}/{color}")
	   public List<CarEntity> getPriceColor(@PathVariable int price,@PathVariable String color) throws PriceColorException, Exception{
		   return carSer.getPriceColor(price,color);
	   }
	   
//   @PutMapping(value="/getColor/{color}/{id}")
//   public CarEntity getColorObject(@PathVariable String color,@PathVariable int id) {
//	   return carSer.getColorObject(color,id);
//   }
   
//   @GetMapping(value="/getColor/{color}")
//   public List<CarEntity> getColor(String color){
//	   return carSer.getColor(color);
//   }
   
   @GetMapping(value="/getIdBrandValue/{model}")
   public List<CarEntity> getIdBrand(@PathVariable int model)throws IdBrandException,Exception{
	   return carSer.getIdBrand(model);
   }
   
   }


