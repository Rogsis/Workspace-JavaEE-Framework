package fr.eni.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.spring.bean.Region;

public interface RegionRepository  extends JpaRepository<Region, Integer>{

}
