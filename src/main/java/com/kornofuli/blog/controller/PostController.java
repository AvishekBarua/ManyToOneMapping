package com.kornofuli.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kornofuli.blog.model.Post;
import com.kornofuli.blog.repository.PostRepository;


@RestController
@RequestMapping(value="/posts")
public class PostController {
	
	private PostRepository postRepo;

	public PostController(PostRepository postRepo) {
		this.postRepo = postRepo;
	}

	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Post> getAll(){
		return postRepo.findAll();
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public List<Post> create(@RequestBody Post post){
		postRepo.save(post);
		return postRepo.findAll(); 
	}
	
	@RequestMapping(value="/helloPost", method=RequestMethod.GET)
	public String hello(){
		return "Avishek";
	}
}
