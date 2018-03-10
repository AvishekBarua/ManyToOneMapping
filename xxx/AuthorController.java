package com.kornofuli.blog;

import java.util.List;
import javax.persistence.Entity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kornofuli.blog.Author;
import com.kornofuli.blog.AuthorRepository;


@Entity
@RequestMapping(value="/Author")
public class AuthorController {
	
	private AuthorRepository authorRepo;

	public AuthorController(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Author> getAll(){
		return authorRepo.findAll();
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(){
		return "Avishek";
	}
}