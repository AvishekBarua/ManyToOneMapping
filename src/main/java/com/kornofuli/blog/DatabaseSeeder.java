package com.kornofuli.blog;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kornofuli.blog.model.Author;
import com.kornofuli.blog.model.Post;
import com.kornofuli.blog.repository.AuthorRepository;
import com.kornofuli.blog.repository.PostRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner{
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private PostRepository postRepo;

	public DatabaseSeeder(AuthorRepository authorRepo, PostRepository postRepo) {
		this.authorRepo = authorRepo;
		this.postRepo = postRepo;
	}

	@Override
	public void run(String... arg0) throws Exception {
		saveData();
	}
	
	@Transactional
	private void saveData(){
		List<Author> authors = new ArrayList<>();
		List<Post> posts = new ArrayList<>();
		
		Author Shanta = new Author("Haimanti", "Barua");
		Author Deepa = new Author("Deepa", "Barua");
		Author Avishek = new Author("Avishek", "Barua");	
		Author Amit = new Author("Amit", "Barua");
		
		authors.add(Shanta);
		authors.add(Deepa);
		authors.add(Avishek);	
		authors.add(Amit);
		
		authorRepo.save(authors);
		
		posts.add(new Post("1 Avishek title", 
        "Avishek lives in Tampere.", Avishek));

		posts.add(new Post("2 Avishek title", 
        "Avishek lives in Finland.", Avishek));
		
		posts.add(new Post("1 Amit title", 
		"Amit lives in Ctg.", Amit));

		posts.add(new Post("1 Shanta title", 
        "Shanta lives in Ctg.", Shanta));

		posts.add(new Post("1 Deepa title", 
        "Deepa lives in Tampere.", Deepa));

		posts.add(new Post("2 Amit title", 
        "Amit lives in Bangladesh.", Amit));
		
		postRepo.save(posts);
		
	}

}
