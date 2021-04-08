package com.example.demo.serviceImp;

import com.example.demo.dto.CommentDTO;

public interface CommentServiceImp {
	public boolean addComment(CommentDTO commentDTO);
	public java.util.List<CommentDTO> getAllComment();
	public boolean deleteComment(int id);
}
