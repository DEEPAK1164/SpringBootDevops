package com.example.Module4.service;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.Module4.dto.PostDTO;
import com.example.Module4.entities.PostEntity;
import com.example.Module4.exception.ResourceNotFoundException;
import com.example.Module4.repositories.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;
	private final ModelMapper mapper;
	
	
	@Override
	public List<PostDTO>getAllPosts(){
		return postRepository.findAll()
				.stream()
				.map(postEntity->mapper.map(postEntity, PostDTO.class))
				.toList();
	}
	
	
	
	@Override
	public PostDTO createNewPost(PostDTO inputPost){

	    // DTO → Entity
	    PostEntity postEntity = mapper.map(inputPost, PostEntity.class);

	    // Save & get managed entity
	    PostEntity savedPost = postRepository.save(postEntity);

	    // Entity → DTO
	    return mapper.map(savedPost, PostDTO.class);
	}



	@Override
	public PostDTO getPostById(long postId) {
		// TODO Auto-generated method stub
		PostEntity postEntity=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found with id "+postId));
		return mapper.map(postEntity, PostDTO.class);
		
	}



	
	
}
