package com.localhost.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localhost.spring.models.HouseModel;


public interface IHouseReporitory extends JpaRepository<HouseModel, Long>{

}
