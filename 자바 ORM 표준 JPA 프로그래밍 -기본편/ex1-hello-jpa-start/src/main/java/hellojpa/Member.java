package hellojpa;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 50 // 성능 최적화를 위해 50으로 설정
)
public class Member {


    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY 전략 - 영속성 컨텍스트에 넣을 때 인서트 쿼리가 날라감.
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    private Long id;


    // 등록, 변경 가능 여부
    @Column(name = "name" , updatable = false)
    private String username;

    // not null 제약조건 , 유니크 제약조건
    @Column(name = "age" , nullable = false , unique = true)
    private Integer age;

    // Enum 타입 매핑 , ORDINAL을 쓰면 코드를 수정했을 때 DB에 순서는 변경되지 않아 위험함
    // STRING 타입 권장
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP) // 잘 사용하지 않음
    private Date lastModifiedDate;

    private LocalDate test1;  // DB에는 date
    private LocalDate test2;  // DB에는 timestamp

    @Lob
    private String description;

    // 메모리에서만 관리하고 싶을 때
    @Transient
    private int temp;

    public Member() {

    } // Constructor


} // end class
