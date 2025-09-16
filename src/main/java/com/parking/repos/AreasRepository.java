package com.parking.repos;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.models.Areas;

@Repository
public interface AreasRepository extends JpaRepository<Areas, Integer> ,JpaSpecificationExecutor<Areas> {
	@Query(value = "select * from shows where fromdate<=?1 and todate>=?1",nativeQuery = true)
	List<Areas> findByDate(String date);
	
	@Query(value="select * from shows where fromDate<=date(now()) and toDate>=date(now())",nativeQuery = true)
	List<Areas> todaysShow();
	
	public List<Areas> findAll(Specification<Areas> spec);
}
