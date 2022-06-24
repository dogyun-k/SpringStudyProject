package com.study.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(
    name = "USER",
    uniqueConstraints = {@UniqueConstraint(     // 유니크 제약조건을 만들어줌
        name = "NAME_EMAIL_UNIQUE",
        columnNames = {"NAME", "EMAIL"}
    )}
)
@Entity(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    // nullable : NOT NULL 제약조건 추가.
    @Column(name = "NAME", nullable = false, length = 10)
    private String name;

    // TODO 로그인 시 이메일 형식 처리
    @Column(name = "EMAIL", nullable = false)
    private String email;

    private String password;

    // 세션을 받고 저장함.
    private String sessionKey = null;

    // Enum Type을 사용하기 위해 필요한 어노테이션. 이걸로 매핑해줘야함.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 날짜 타입은 Temporal 어노테이션으로 매핑해줘야 함.
    // Temporal 뜻 : 형) 시간의
    @Temporal(TemporalType.DATE)
    private final Date createDate = new Date();

    // DB의 CLOB타입으로 매핑하기 위함
    // CLOB, BLOB 타입은 길이 제한이 없다.
    @Lob
    private String description;

    @OneToMany(mappedBy = "user")
    private List<Post> post = new ArrayList<Post>();

//     기본 생성자 ( 다른 생성자가 없으면 굳이 안 해도 됨 )
    // 롬복의 NoArguConstructor로 대체 가능
//    protected User() {
//    }

    @Builder
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public enum RoleType {
        ADMIN, USER
    }

}
