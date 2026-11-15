package ea.digites.blogger.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.digites.blogger.persistence.model.Post;
import ea.digites.blogger.persistence.repository.PostRepository;

@Service
public class PostService implements IPostService {

	private PostRepository postRepository;
	
	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@Override
	@Transactional
	public Post savePost(final Post post) {
		post.setLikeCount(0);
		post.setViewCount(0);
		post.setDate(new Date());
		return postRepository.save(post);
	}
	
}
