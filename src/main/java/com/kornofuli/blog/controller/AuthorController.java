package com.kornofuli.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kornofuli.blog.model.Author;
import com.kornofuli.blog.repository.AuthorRepository;

@RestController
@RequestMapping(value="/authors")
@CrossOrigin(origins = "*")
public class AuthorController {
	
	private AuthorRepository authorRepo;

	public AuthorController(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Author> getAll(){
		return authorRepo.findAll();
	}
	
	@RequestMapping(value="/allposts", method=RequestMethod.GET)
	public ModelAndView getAllposts(){
			
			ModelAndView mv = new ModelAndView("/Blog");
			mv.addObject("authors", authorRepo.findAll());
			
			return mv;
	}
		
	@RequestMapping(value="/search/{search}", method=RequestMethod.GET)
	public List<Author> search(@PathVariable String search){
		//return authorRepo.findAll();
		return authorRepo.search(search); 
	}

	
	@RequestMapping(value="/searchbyid/{id}", method=RequestMethod.GET)
	public List<Author> searchById(@PathVariable Long id){
		return authorRepo.findById(id); 
	}
	
	
	@RequestMapping(value="/searchbyname/{name}", method=RequestMethod.GET)
	public List<Author> searchByName(@PathVariable String name){
		return authorRepo.findByFirstName(name); 
	}
	
	@RequestMapping(value="/searchbyword/{word}", method=RequestMethod.GET)
	public List<Author> searchByWord(@PathVariable String word){
		return authorRepo.findByFirstNameContaining(word); 
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public List<Author> create(@RequestBody Author author){
		authorRepo.save(author);
		return authorRepo.findAll(); 
	}
	
	@RequestMapping(value="/helloAuthor", method=RequestMethod.GET)
	public String hello(){
		return "Avishek";
	}
}