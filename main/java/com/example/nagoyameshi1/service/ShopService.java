package com.example.nagoyameshi1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.nagoyameshi1.model.Shop;
import com.example.nagoyameshi1.repository.ShopRepository;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }
}
