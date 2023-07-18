package com.cust.movie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Order extends BaseEntity implements Serializable {
    private Integer oid;
    private Integer uid;
    private Integer mid;
    private Integer amount;
    private Integer ticketStatus;
}
