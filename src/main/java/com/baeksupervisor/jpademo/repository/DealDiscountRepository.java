package com.baeksupervisor.jpademo.repository;

import com.baeksupervisor.jpademo.persistence.DealDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Seunghyun.Baek
 * Since 2020/03/01
 */
public interface DealDiscountRepository extends JpaRepository<DealDiscount, Long> {
}
