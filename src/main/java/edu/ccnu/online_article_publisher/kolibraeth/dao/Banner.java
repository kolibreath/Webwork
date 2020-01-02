package edu.ccnu.online_article_publisher.kolibraeth.dao;


import javax.persistence.*;

@Entity
@Table(name ="banner")
public class Banner {

    @GeneratedValue
    @Id
    private int bannerId;

    @Column
    private String bannerPicId;

    @Column
    private String bannerContentId;

    @Column
    private long time;

    @Column
    private String bannerIntro;

    public Banner(){}

    public Banner(String bannerPicId, String bannerContentId, long time, String bannerIntro) {
        this.bannerPicId = bannerPicId;
        this.bannerContentId = bannerContentId;
        this.time = time;
        this.bannerIntro = bannerIntro;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getBannerIntro() {
        return bannerIntro;
    }

    public void setBannerIntro(String bannerIntro) {
        this.bannerIntro = bannerIntro;
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerPicId() {
        return bannerPicId;
    }

    public void setBannerPicId(String bannerPicId) {
        this.bannerPicId = bannerPicId;
    }

    public String getBannerContentId() {
        return bannerContentId;
    }

    public void setBannerContentId(String bannerContentId) {
        this.bannerContentId = bannerContentId;
    }


}
