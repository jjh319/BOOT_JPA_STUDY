package hellojpa;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member2 {


    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;


    // 일대다 양방향 사용x 이거 말고 다대일 양방향을 사용하자
    @ManyToOne
    @JoinColumn(name = "TEAM_ID",insertable = false, updatable = false)
    private Team team;


} // end class
