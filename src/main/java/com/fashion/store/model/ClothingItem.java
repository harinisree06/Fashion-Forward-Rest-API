package com.fashion.store.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clothing_items")
public class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    
    private String size;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public ClothingItem() {}

    public ClothingItem(Long id, String description, String size, User user) {
        this.id = id;
        this.description = description;
        this.size = size;
        this.user = user;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
