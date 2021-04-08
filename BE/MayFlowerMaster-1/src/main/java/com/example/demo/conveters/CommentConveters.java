package com.example.demo.conveters;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CommentDTO;
import com.example.demo.entity.Comment;

@Component
public class CommentConveters {
	public boolean commentDTOtoComment(CommentDTO commentDTO, Comment comment) {
			comment.setContent(commentDTO.getContent());
			comment.setGmail(commentDTO.getGmail());
			comment.setUsernamecomment(commentDTO.getUsernamecomment());
		return true;
	}
	public boolean commentToCommentDTO(CommentDTO commentDTO, Comment comment) {
		commentDTO.setIdcomment(comment.getIdcomment());
		commentDTO.setContent(comment.getContent());
		commentDTO.setGmail(comment.getGmail());
		commentDTO.setUsernamecomment(comment.getUsernamecomment());
	return true;
	}
}
