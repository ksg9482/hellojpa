package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
//시퀀스 전략시 시퀀스를 테이블마다 따로 둘 때
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;
    //테이블과 객체 이름이 다를 때
    @Column(name = "name")
    private String username;

    //Integer에 가장 적합한 숫자타입이 선택됨
    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //DATE - 날짜, TIME - 시간, DATETIME - 날짜시간(TIMESTAMP)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //(varchar를 넘어서는 큰 컨텐츠) LOB - 구조화 되지 않은 큰 데이터, BLOB - 이진(Binary) 대형 객체, CLOB - 문자(Character) 대형 객체
    @Lob
    private String description;

    //DB에 컬럼 만들지 않고 객체에서만 사용
    @Transient
    private int temp;
}
