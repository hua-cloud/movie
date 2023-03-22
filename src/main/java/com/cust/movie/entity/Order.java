package com.cust.movie.entity;

import java.io.Serializable;

public class Order extends BaseEntity implements Serializable {
    private Integer oid;
    private Integer uid;
    private Integer mid;
    private Integer amount;
    private Integer ticketStatus;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", mid=" + mid +
                ", amount=" + amount +
                ", ticketStatus=" + ticketStatus +
                '}' + super.toString();
    }
}
