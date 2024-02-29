package com.localhost.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.localhost.spring.models.PersonModel;

public interface IPersonReporitory extends JpaRepository<PersonModel, Long> {

}
