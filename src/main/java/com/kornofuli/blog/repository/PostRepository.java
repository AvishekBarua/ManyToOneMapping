package com.kornofuli.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kornofuli.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
