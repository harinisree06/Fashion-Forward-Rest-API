package com.fashion.store.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClothingItem> clothingItems;

    // Constructors
    public User() {}

    public User(Long id, String name, String email, List<ClothingItem> clothingItems) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.clothingItems = clothingItems;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<ClothingItem> getClothingItems() { return clothingItems; }
    public void setClothingItems(List<ClothingItem> clothingItems) { this.clothingItems = clothingItems; }
}
