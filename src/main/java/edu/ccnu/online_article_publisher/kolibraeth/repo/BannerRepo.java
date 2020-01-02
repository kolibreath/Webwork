package edu.ccnu.online_article_publisher.kolibraeth.repo;


import edu.ccnu.online_article_publisher.kolibraeth.dao.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepo  extends JpaRepository<Banner,Integer> {

    Banner findBannerByBannerId(int id);
    List<Banner> findByBannerContentId(String content);
}
