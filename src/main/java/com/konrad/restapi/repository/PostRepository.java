package com.konrad.restapi.repository;

import com.konrad.restapi.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    //1 option for query
//    @Query("select p from Post p where title = ?1")
//    List<Post> findAllByTitle(String title);

    //2 option for query with @Param
//    @Query("select p from Post p where title = :title")
//    List<Post> findAllByTitle(@Param("title") String title);

    //3 option for query by default method
    List<Post> findAllByTitle(String title);

    //Query with option for paging without limit on the database side
//    @Query("select p from Post p" + " left join fetch  p.comments")
//    List<Post> findAllPosts(Pageable page);

    //Query with option for paging with limit on the database side
    @Query("select p from Post p")
    List<Post> findAllPosts(Pageable page);
}
