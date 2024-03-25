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

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne // 멤버가 많고 TEAM이 하나기 때문에 ( 1 : N )
    @JoinColumn(name = "TEAM_ID")
    private Team team;



    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    } // changeTeam

} // end class
