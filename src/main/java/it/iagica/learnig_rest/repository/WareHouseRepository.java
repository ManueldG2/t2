package it.iagica.learnig_rest.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import it.iagica.learnig_rest.entity.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse, Long>{

	
}
