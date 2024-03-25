package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

//    @Column(name = "order_id")
//    private Long orderId;
//
//    @Column(name = "item_id")
//    private Long itemId;

    @ManyToOne
    @Column(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @Column(name = "ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;

} // end class
