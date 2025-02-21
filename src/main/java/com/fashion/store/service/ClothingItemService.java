package com.fashion.store.service;

import com.fashion.store.model.ClothingItem;
import com.fashion.store.repository.ClothingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClothingItemService {

    @Autowired
    private ClothingItemRepository clothingItemRepository;

    public ClothingItem createClothingItem(ClothingItem clothingItem) {
        return clothingItemRepository.save(clothingItem);
    }

    public Page<ClothingItem> getClothingItems(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return clothingItemRepository.findAll(PageRequest.of(page, size, sort));
    }

    public Optional<ClothingItem> getClothingItemById(Long id) {
        return clothingItemRepository.findById(id);
    }

    public ClothingItem updateClothingItem(Long id, ClothingItem clothingItemDetails) {
        ClothingItem clothingItem = clothingItemRepository.findById(id).orElseThrow();
        clothingItem.setDescription(clothingItemDetails.getDescription());
        clothingItem.setSize(clothingItemDetails.getSize());
        return clothingItemRepository.save(clothingItem);
    }

    public void deleteClothingItem(Long id) {
        clothingItemRepository.deleteById(id);
    }
}
