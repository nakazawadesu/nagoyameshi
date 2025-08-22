package com.example.nagoyameshi1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi1.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 店舗ごとのレビュー一覧を取得
    List<Review> findByShopId(Long shopId);
}
