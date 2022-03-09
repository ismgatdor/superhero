package com.hero.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hero.data.entity.SuperheroEntity;

@Repository
@Transactional(readOnly = true)
public interface SuperheroRepository extends JpaRepository<SuperheroEntity, Long>{

	@Query("select s from SuperheroEntity s where s.heroName like %:name%")
	public List<SuperheroEntity> findLikeName(@Param("name") String name);
	
}
