package com.konrad.restapi.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class CommentDto {

    private String content;
    private LocalDateTime created;

}
