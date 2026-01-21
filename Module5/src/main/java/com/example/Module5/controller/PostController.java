package com.example.Module5.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Module5.dto.PostDTO;
import com.example.Module5.services.PostService;
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
	@PutMapping("/{postId}")
	public PostDTO updatePost(@RequestBody PostDTO inputPost,@PathVariable long postId) {
		return postService.updatePost(inputPost,postId);
	}

}
