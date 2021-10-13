package com.konrad.restapi.service;

import com.konrad.restapi.controller.dto.CommentDto;
import com.konrad.restapi.model.Comment;
import com.konrad.restapi.model.Post;
import com.konrad.restapi.repository.CommentRepository;
import com.konrad.restapi.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public List<Comment> getComments(long id) {
        return postRepository.getById(id).getComments();
    }

    public Comment getSingleComment(long id) {
        return commentRepository.findById(id).orElseThrow();
    }

    public Comment getSingleCommentFromSpecificPost(long idPost, long idComment) {
        Post post = postRepository.getById(idPost);
        return post.getComments().stream()
                .filter(comment -> comment.getId() == idComment)
                .findAny()
                .orElse(null);
    }


    public void addComment(long id, CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setCreated(commentDto.getCreated());
//        comment.setPostId(id); // to nie będzie potrzebne
        commentRepository.save(comment);
        Post byId = postRepository.findById(id).orElseThrow();
        byId.addComment(comment);
        int a = 3;
//
//        comment.setPostId(id);
//        commentRepository.save(comment);

//        commentRepository.save(comment);
//        List<Comment> comments = postRepository.getById(id).getComments();
//        comments.add(comment);
//        postRepository.getById(id).setComments(comments);
    }
}
