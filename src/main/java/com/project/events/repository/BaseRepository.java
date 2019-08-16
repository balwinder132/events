package com.project.events.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID>{
	
	public void delete(T object);
	
	public List<T> findAll();
	
	Optional<T> findById(Long id);
	
	public T save(T object);

}