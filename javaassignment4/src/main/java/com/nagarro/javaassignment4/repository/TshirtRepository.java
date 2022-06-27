package com.nagarro.javaassignment4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.javaassignment4.model.Tshirt;

@Repository
public interface TshirtRepository 
	extends JpaRepository<Tshirt,Long>{
	@Query("select t from Tshirt t order by t.price asc, t.rating asc")
	List<Tshirt> findTshirtsOrdered();
	
	@Query("select t from Tshirt t where lower(t.colour) = ?1 order by t.price asc, t.rating asc")
	List<Tshirt> findTshirtsOrderByPrice(String color , String size);
	
	@Query("select t from Tshirt t where lower(t.colour) = ?1 order by t.rating asc, t.price asc")
	List<Tshirt> findTshirtsOrderByRating(String color , String size);
}
