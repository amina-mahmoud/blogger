package ea.digites.blogger.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ea.digites.blogger.persistence.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
