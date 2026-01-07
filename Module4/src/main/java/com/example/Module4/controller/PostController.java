package com.example.Module4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Module4.dto.PostDTO;
import com.example.Module4.entities.PostEntity;
import com.example.Module4.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path="/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
	
	@GetMapping
	public List<PostDTO>getAllPosts(){
		return postService.getAllPosts();
	}
	
	
	@PostMapping
	public PostDTO createNewPost(@RequestBody PostDTO inputPost) {
		return postService.createNewPost(inputPost);
	}
	
	@GetMapping("/{postId}")
	public PostDTO getPostById(@PathVariable long postId) {
		return postService.getPostById(postId);
	}
	

}
