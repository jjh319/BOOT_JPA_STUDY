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

            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("BBB");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = " + findMovie);


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        } // try-catch-finally

        emf.close();


    } // main

} // end class
