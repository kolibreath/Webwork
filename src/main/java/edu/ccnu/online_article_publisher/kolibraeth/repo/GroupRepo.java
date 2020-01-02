package edu.ccnu.online_article_publisher.kolibraeth.repo;

import edu.ccnu.online_article_publisher.kolibraeth.dao.ArticleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<ArticleGroup,Integer> {
}
