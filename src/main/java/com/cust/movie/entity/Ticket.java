package com.cust.movie.entity;

import java.io.Serializable;

/** 电影票相关数据的实体类*/
public class Ticket extends BaseEntity implements Serializable{
    private Integer mid;
    private String title;
    private Integer categoryId;
    private Long price;
    private Integer num;
    private String image;

    public Integer getId() {
        return mid;
    }

    public void setId(Integer id) {
        this.mid = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        if (!super.equals(o)) return false;

        Ticket ticket = (Ticket) o;

        if (getId() != null ? !getId().equals(ticket.getId()) : ticket.getId() != null) return false;
        if (getTitle() != null ? !getTitle().equals(ticket.getTitle()) : ticket.getTitle() != null) return false;
        if (getCategoryId() != null ? !getCategoryId().equals(ticket.getCategoryId()) : ticket.getCategoryId() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(ticket.getPrice()) : ticket.getPrice() != null) return false;
        if (getNum() != null ? !getNum().equals(ticket.getNum()) : ticket.getNum() != null) return false;
        return getImage() != null ? getImage().equals(ticket.getImage()) : ticket.getImage() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getCategoryId() != null ? getCategoryId().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + mid +
                ", title='" + title + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", num=" + num +
                ", image='" + image + '\'' +
                '}' + super.toString();
    }
}
