package com.study.board.domain;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity(name = "Post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POST_ID")
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.DATE)
    private final Date createDate = new Date();

    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")       // User_ID 키를 관리할 주인은 POST와 USER중 누가 해야할까?
    private User user;
    // 연관관계의 주인을 설정.. 주인만이 수정할 수 있는데
    // 그러면 유저가 주인이 되서 포스트를 수정할 수 있게 해야하지 않을까
    // 주인이 아닌 쪽은 외래 키를 변경하지는 못 한다..
    // 외래키를 변경한다는 의미 : 참조하는 대상을 바꾼다. 유저가 주인이라고 치면 외래키는 포스트 아이디이고 포스트 아이디를 바꾼다?
    // 이거는 있을 수 없는 일 아닌가.
    // 여기서는 둘 다 수정 될 필요가 없으니 주인이 누가 되든 상관이 없는 듯.
    // 근데 책에서는 항상 "다" 쪽이 주인을 한다고 하네요. 고로 여기서는 포스트가 주인이 되야 하네요.
    // 아예 ManyToOne에는 "mappedBy"옵션이 없네요.

    protected Post() {
    }

    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

}
