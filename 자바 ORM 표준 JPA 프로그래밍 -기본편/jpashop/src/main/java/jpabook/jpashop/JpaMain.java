package jpabook.jpashop;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

public class JpaMain {


    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Order order = new Order();
            em.persist(order);

//            order.addOrderItem(new OrderItem());

            OrderItem orderItems = new OrderItem();
            orderItems.setOrder(order);
            em.persist(orderItems);

            tx.commit();

        } catch (Exception e) {

            tx.rollback();

        } finally {

            em.close();

        } // try-catch-finally


        emf.close();

    } // main

} // end class
