package com.konrad.restapi.controller;

import com.konrad.restapi.service.CommentService;
import com.konrad.restapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;
    
}
