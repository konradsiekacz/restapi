package com.konrad.restapi.service;

import com.konrad.restapi.controller.dto.PostDto;
import com.konrad.restapi.model.Comment;
import com.konrad.restapi.model.Post;
import com.konrad.restapi.repository.CommentRepository;
import com.konrad.restapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    public static final int PAGE_SIZE = 3;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    public List<Post> getPosts(int page, Sort.Direction sort) {
        return postRepository.findAllPosts(
                PageRequest.of(page, PAGE_SIZE,
                        Sort.by(sort, "id"))
        );
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    public List<Post> getPostsByTitle(String title) {
        return postRepository.findAllByTitle(title);
    }

    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id")));
        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAll();
        allPosts.forEach(post -> post.setComments(extractComments(comments, post.getId())));
        return allPosts;
    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getId() == id)
                .collect(Collectors.toList());
    }

    public Post addPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setCreated(postDto.getCreated());
        return postRepository.save(post);
    }

    @Transactional
    public Post editPost(Post post) {
        Post postEditet = postRepository.findById(post.getId()).orElseThrow();
        postEditet.setTitle(post.getTitle());
        postEditet.setContent(post.getContent());
        return postEditet;
    }

    public void deleteSinglePost(Long id) {
        postRepository.deleteById(id);
    }

}
