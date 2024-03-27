package hellojpa;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("M")  // 부모 테이블의 칼럼명을 현재 테이블명이 아니라 M 으로 바꿈
public class Movie extends Item{

    private String director;
    private String actor;

} // end class
