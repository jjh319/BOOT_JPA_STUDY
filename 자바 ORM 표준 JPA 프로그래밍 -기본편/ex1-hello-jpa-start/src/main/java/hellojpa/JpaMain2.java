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

            Member2 member2 = new Member2();
            member2.setUsername("member1");

            em.persist(member2);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member2);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        } // try-catch-finally

        emf.close();


    } // main

} // end class
