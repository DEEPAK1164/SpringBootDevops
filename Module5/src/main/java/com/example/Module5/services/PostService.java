package com.example.Module5.services;

import java.util.List;
import java.util.Optional;

import com.example.Module5.dto.PostDTO;
import com.example.Module5.entities.PostEntity;

// we cant create beans for interface
public interface PostService {
  
	 List<PostDTO>getAllPosts();
	 PostDTO createNewPost(PostDTO inputPost);
	 PostDTO getPostById(long postId);
	 PostDTO updatePost(PostDTO inputPost, long postId);
	
}