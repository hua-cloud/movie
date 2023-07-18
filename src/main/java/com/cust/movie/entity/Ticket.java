package com.cust.movie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Ticket extends BaseEntity implements Serializable{
    private Integer mid;
    private String title;
    private Integer categoryId;
    private Long price;
    private Integer num;
    private String image;
}
