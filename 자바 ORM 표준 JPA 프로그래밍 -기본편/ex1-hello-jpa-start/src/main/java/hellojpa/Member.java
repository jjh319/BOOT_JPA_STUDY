package hellojpa;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Member {

    @Id
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
