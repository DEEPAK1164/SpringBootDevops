package com.example.Module5.services;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.Module5.dto.PostDTO;
import com.example.Module5.entities.PostEntity;
import com.example.Module5.exceptions.ResourceNotFoundException;
import com.example.Module5.repositories.PostRepository;
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



	@Override
	public PostDTO updatePost(PostDTO inputPost, long postId) {
		// TODO Auto-generated method stub
		PostEntity olderPost=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post not found with id "+postId));
		inputPost.setId(postId);
		mapper.map(inputPost, olderPost);
		PostEntity savedPostEntity=postRepository.save(olderPost);
		return mapper.map(savedPostEntity, PostDTO.class);
		
	}



	
	
}
