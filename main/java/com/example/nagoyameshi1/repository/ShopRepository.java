package com.example.nagoyameshi1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi1.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    // 店舗名にキーワードを含む検索
    List<Shop> findByNameContaining(String keyword);

    // ジャンルで検索
    List<Shop> findByGenre(String genre);
}
