package edu.ccnu.online_article_publisher.kolibraeth.repo;

import com.sun.tools.javac.util.List;
import edu.ccnu.online_article_publisher.kolibraeth.dao.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleRepo extends JpaRepository<Article,Integer> {

    List<Article> findByUserId(int userId);
}
