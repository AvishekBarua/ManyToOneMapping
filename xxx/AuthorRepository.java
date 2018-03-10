package com.kornofuli.blog;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kornofuli.blog.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
