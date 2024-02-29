package com.localhost.spring.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localhost.spring.models.HouseModel;
import com.localhost.spring.repositories.IHouseReporitory;

@Service
public class HouseService {
	@Autowired
	IHouseReporitory houseRepository; // dependencias inyectadas
	
	// metodo que devuelve todas las casas
	public ArrayList<HouseModel> getHouses(){
		return (ArrayList<HouseModel>) houseRepository.findAll(); 
	}
	
	public HouseModel saveHouse(HouseModel house) {
		return houseRepository.save(house);
	}
	
	public Optional<HouseModel> getById(Long id){
		return houseRepository.findById(id);
	}
	
	public HouseModel updateById(HouseModel request,Long id){
		HouseModel house = houseRepository.findById(id).get();
		house.setDireccion(request.getDireccion());
		house.setCp(request.getCp());
		houseRepository.save(house);
		return house;
	}
	

	public Boolean deleteHouse(Long id) {
		try {
			houseRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
