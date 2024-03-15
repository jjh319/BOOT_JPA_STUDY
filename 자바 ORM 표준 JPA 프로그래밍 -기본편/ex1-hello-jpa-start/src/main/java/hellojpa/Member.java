package hellojpa;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id
    private Long id;

    private String name;


    public Long getId() {
        return id;
    } // getId

    public void setId(Long id) {
        this.id = id;
    } // setId

    public String getName() {
        return name;
    } // getName

    public void setName(String name) {
        this.name = name;
    } // setName


} // end class
