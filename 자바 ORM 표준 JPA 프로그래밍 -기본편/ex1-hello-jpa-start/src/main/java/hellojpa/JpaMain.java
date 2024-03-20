package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try {

//            // Insert
            Member member = new Member();
//            member.setId("scv2122");
            member.setUsername("HelloBB");
//
            em.persist(member);
//
//            // 조회
//            Member findMember = em.find(Member.class, 1L);
//
//            //삭제
//            em.remove(findMember);
//
//            //수정
//            findMember.setName("HelloJPA");


            // JPQL
//            List<Member> list = em.createQuery("SELECT m FROM Member as m", Member.class)
//                    .getResultList();
//
//            for(Member member : list) {
//                System.out.println(member.getName());
//            }


            // 영속성
//            Member findMember1 = em.find(Member.class,101L);
//            Member findMember2 = em.find(Member.class,101L);
//
//            findMember1.setUsername("ADNINN");
//            findMember2.setUsername("hon22");
//
//            // 준영속 : 영속 상태에서 값을 빼낸다.
//            em.detach(findMember1);
//            em.clear();
//            em.close();


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        } // try-catch-finally

        emf.close();
    } // main

} // end class
