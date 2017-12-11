package com.vip.movie.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**

 * Created by chentong on 2017/12/9.
 */
@Entity
public class User {
    //一直可添加

    @Id(autoincrement = true)
    private Long id;
    private int type;
    private String name;
    private String pic;
    private String video;
    @Generated(hash = 1528142015)
    public User(Long id, int type, String name, String pic, String video) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.pic = pic;
        this.video = video;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getVideo() {
        return this.video;
    }
    public void setVideo(String video) {
        this.video = video;
    }



}
