package com.kornofuli.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kornofuli.blog.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	@Query("select auth from Author auth where auth.firstName like %:word%") 
	public List<Author> search(@Param("word") String search);

	
	List<Author> findById(Long id);
	List<Author> findByFirstName(String name);
	List<Author> findByFirstNameContaining(String word);
	
}
