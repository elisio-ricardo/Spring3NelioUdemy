package com.spring3nelio.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring3nelio.course.entities.enums.OrdersStatus;
import com.spring3nelio.course.service.OrderService;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer ordersStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {
    }

    public Order(Long id, Instant moment, OrdersStatus ordersStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrdersStatus(ordersStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrdersStatus getOrdersStatus() {
        return OrdersStatus.valueOf(ordersStatus);
    }

    public void setOrdersStatus(OrdersStatus ordersStatus) {
        if (ordersStatus != null) {
            this.ordersStatus = ordersStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
