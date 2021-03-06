package com.hero.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hero.data.entity.PowerEntity;

@Repository
public interface PowerRepository extends JpaRepository<PowerEntity, Long>{

}
