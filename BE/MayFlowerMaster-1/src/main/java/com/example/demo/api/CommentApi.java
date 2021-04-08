package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentApi {

	@Autowired
	private CommentService commentService;
	@GetMapping
	public List<CommentDTO> getAllComment(){
		return (List<CommentDTO>) commentService.getAllComment();
	}
	@PostMapping
	public boolean addComment(@RequestBody CommentDTO commentDTO) {
		boolean flag = true;
		try {
			commentService.addComment(commentDTO);
		} catch (Exception e) {
			flag= false;
		}
		return flag;
		
	}
	@DeleteMapping
	public boolean deleteComment(@RequestBody CommentDTO commentDTO) {
		if(commentService.deleteComment(commentDTO.getIdcomment())) {
			return true;
		}
		return false;
		
	}
	
}
