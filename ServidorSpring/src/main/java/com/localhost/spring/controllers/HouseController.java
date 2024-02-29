package com.localhost.spring.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localhost.spring.models.HouseModel;
import com.localhost.spring.services.HouseService;

@RestController
@RequestMapping("/house")
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
		// obtiene todas las casas
		@GetMapping
		public ArrayList<HouseModel> getHouses(){
			return this.houseService.getHouses();
		}
		
		// crea una nueva casa
		@PostMapping
		public HouseModel saveHouse(@RequestBody HouseModel house) {
			return this.houseService.saveHouse(house);
		}
		// obtiene la casa por el id
		@GetMapping(path="/{id}")
		public Optional<HouseModel> getHouseById(@PathVariable("id") Long id){
		    return this.houseService.getById(id);
		}

		
		@PutMapping(path="/{id}")
		public HouseModel updateById(@RequestBody HouseModel request,@PathVariable("id") Long id ) {
			return this.houseService.updateById(request, id);
			}
		
		@DeleteMapping(path="/{id}")	
		public String deleteById(@PathVariable("id") Long id) {
			boolean ok= this.houseService.deleteHouse(id);
			
			if(ok) {
				return "La casa con id " + id + " ha sido eliminada!";
			}
			else {
				return "Error, no es posible borrar la casa con id " + id;
			}
		}
}
















