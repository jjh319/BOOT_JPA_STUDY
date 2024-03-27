package hellojpa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // 조인 테이블 전략
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 단일 테이블 전략
@DiscriminatorColumn // DTYPE = 해당 테이블명을 부모 테이블의 칼럼으로 추가
public class Item {


    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

} // end class
