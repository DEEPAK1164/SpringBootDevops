package com.example.Module4.service;

import java.util.List;
import java.util.Optional;

import com.example.Module4.dto.PostDTO;
import com.example.Module4.entities.PostEntity;

// we cant create beans for interface
public interface PostService {
  
	 List<PostDTO>getAllPosts();
	 PostDTO createNewPost(PostDTO inputPost);
	 PostDTO getPostById(long postId);
	
}
