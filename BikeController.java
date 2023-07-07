package com.example.vehicle.controller;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicle.entity.BikeEntity;
import com.example.vehicle.entity.CarEntity;
import com.example.vehicle.globalExceptionHandling.PriceException;
import com.example.vehicle.service.BikeService;

@RestController
@RequestMapping(value = "/bike")
public class BikeController {
	@Autowired
	BikeService bikeser;
	static Logger log = Logger.getLogger(BikeController.class);

	@PostMapping(value = "/insert1")
	public String insertValue(@RequestBody BikeEntity e) {
		return bikeser.insertValue(e);
	}

	@PostMapping(value = "/insert2")
	public String putValue(@RequestBody BikeEntity e) throws PriceException {
		return bikeser.putValue(e);
	}

	@PostMapping(value = "/insertAllValue")
	public String insertAll1(@RequestBody List<BikeEntity> e) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(bikeser.insertAll1(e));
		return bikeser.insertAll1(e);
	}

	@GetMapping(value = "/getId1/{id}")
	public BikeEntity getId(@PathVariable int id) {
		return bikeser.getId(id);

	}

	@GetMapping(value = "/getAll1")
	public List<BikeEntity> getAll() {
		PropertyConfigurator.configure("log4j.properties");
		log.info(bikeser.getAll());
		return bikeser.getAll();
	}

	@DeleteMapping(value = "/delete1/{id}")
	public List<BikeEntity> getDelete(@PathVariable int id) {
		PropertyConfigurator.configure("log4j.Properties");
		log.info(bikeser.getDelete(id));
		return bikeser.getDelete(id);
	}

	@PutMapping(value = "/update1/{id}")
	public String getUpdate(@RequestBody BikeEntity id) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(bikeser.getUpdate(id));
		return bikeser.getUpdate(id);
	}

}
