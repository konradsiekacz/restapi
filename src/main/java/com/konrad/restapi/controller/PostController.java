package com.konrad.restapi.controller;

import com.konrad.restapi.controller.dto.CommentDto;
import com.konrad.restapi.controller.dto.PostDto;
import com.konrad.restapi.model.Comment;
import com.konrad.restapi.model.Post;
import com.konrad.restapi.service.CommentService;
import com.konrad.restapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;  //if page is greater or equals to 0 return page else return 0
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return PostDtoMapper.maptToPostDtos(postService.getPosts(pageNumber, sortDirection));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComments(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;  //if page is greater or equals to 0 return page else return 0
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return postService.getPostsWithComments(pageNumber, sortDirection);
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id) {
        return postService.getSinglePost(id);
    }

//    @GetMapping("/posts/{title}")
//    public List<Post> getPostsByTitle(@RequestParam(value = "title") String title) {
//        return postService.getPostsByTitle(title);
//    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody PostDto postDto) {
        return postService.addPost(postDto);
    }

    @PutMapping("/posts")
    public Post editPost(@RequestBody Post post) {
        return postService.editPost(post);
    }

    @DeleteMapping("posts/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deleteSinglePost(id);
    }

    @GetMapping("posts/{id}/comments/{commentId}")
    public Comment getSingleComment(@PathVariable long id, @PathVariable long commentId) {
        return commentService.getSingleCommentFromSpecificPost(id, commentId);
    }

    @GetMapping("posts/{postId}/comments")
    public List<Comment> getComments(@PathVariable long postId) {
        return commentService.getComments(postId);
    }

    @PostMapping("posts/{postId}/comments")
    public void addComment(@RequestBody CommentDto commentDto, @PathVariable long postId) {
        commentService.addComment(postId, commentDto);
    }
}
