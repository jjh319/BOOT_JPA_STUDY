package hellojpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class JpaMain2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member2 member2 = new Member2();
            member2.setUsername("member1");
            member2.changeTeam(team);
            em.persist(member2);

//            team.getMembers().add(member2); // 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정

            // 영속성 컨텍스트를 클리어해서 DB에서 뽑아오도록 하기 위함
            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member2> members = findTeam.getMembers();

            for(Member2 m : members) {
                System.out.println("m = " + m.getUsername());
            } // for

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        } // try-catch-finally

        emf.close();


    } // main

} // end class
