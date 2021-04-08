package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.conveters.CommentConveters;
import com.example.demo.dto.CommentDTO;
import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import com.example.demo.serviceImp.CommentServiceImp;


@Service
public class CommentService implements CommentServiceImp{
	@Autowired 
	private CommentRepository commentRepository;
	@Autowired
	private CommentConveters commentConveters;
	@Override
	public boolean addComment(CommentDTO commentDTO) {
		Comment comment = new Comment();
		commentConveters.commentDTOtoComment(commentDTO, comment);
		commentRepository.save(comment);
		return true;
	}
	@Override
	public java.util.List<CommentDTO> getAllComment() {
		java.util.List<Comment> listComment =  commentRepository.findAll();
		java.util.List<CommentDTO> listCommentDTO = new ArrayList<CommentDTO>();
		for(Comment comment : listComment) {
			CommentDTO commentDTO = new CommentDTO();
			commentConveters.commentToCommentDTO(commentDTO, comment);
			listCommentDTO.add(commentDTO);	
		}
		return listCommentDTO;
	}
	@Override
	public boolean deleteComment(int id) {
		boolean flag= true;
		try {
			commentRepository.deleteById(id);
		} catch (Exception e) {
			flag= false;
		}
		return flag;
	}
	

}
