package com.baeksupervisor.jpademo.repository;

import com.baeksupervisor.jpademo.persistence.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Seunghyun.Baek
 * Since 2020/03/01
 */
public interface DealRepository extends JpaRepository<Deal, Long> {
    @Query("select d from Deal d join fetch d.dealDiscount")
    List<Deal> findAllJoinFetch();
}
