package com.github.bartkoo98.traveltreasuresfinal.treasure;

import java.math.BigDecimal;

public class TreasureDto {
    private Long id;
    private String title;
    private String destination;
    private String dates;
    private BigDecimal price;
    private String link;
    private String description;
    private boolean promoted;
    private String photo;
    private String category;

    public TreasureDto(Long id, String title, String destination, String dates, BigDecimal price, String link, String description, boolean promoted, String category) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.dates = dates;
        this.price = price;
        this.link = link;
        this.description = description;
        this.promoted = promoted;
        this.category = category;
    }


    public TreasureDto() {};
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
