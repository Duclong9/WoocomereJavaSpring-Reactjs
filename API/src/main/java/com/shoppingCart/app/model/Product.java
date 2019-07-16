package com.shoppingCart.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products", catalog = "shopping_cart_db")
public class Product implements java.io.Serializable {

    private Long idProduct;
    private Category category;
    private String description;
    private BigDecimal price;
    private int quantity;
    private List<LineItem> linesItems = new ArrayList<LineItem>();

    public Product() {
    }

    public Product(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public Product(Category category, String description, BigDecimal price, int quantity, List<LineItem> linesItems) {
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.linesItems = linesItems;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idproduct", unique = true, nullable = false)
    public Long getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategory")
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "description", nullable = false, length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price", nullable = false, precision = 10)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "quantity", nullable = false, precision = 10)
    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    public List<LineItem> getLinesItems() {
        return this.linesItems;
    }

    public void setLinesItems(List<LineItem> linesItems) {
        this.linesItems = linesItems;
    }

}
