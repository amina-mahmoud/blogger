package ea.digites.blogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ea.digites.blogger.persistence.model.Post;
import ea.digites.blogger.service.IPostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	private IPostService postService;
	
	@Autowired
	public PostController(IPostService postService) {
		this.postService = postService;
	}
	
	@PostMapping
	public ResponseEntity<?> createPost(@RequestBody Post post) {
		try {
			final Post createdPost = postService.savePost(post);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
 	
}
