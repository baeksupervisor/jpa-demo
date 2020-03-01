package com.baeksupervisor.jpademo.persistence;

import com.baeksupervisor.jpademo.model.DiscountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Seunghyun.Baek
 * Since 2020/03/01
 */
@Getter
@NoArgsConstructor
@Entity
public class DealDiscount {

    @Id
    @Column(name = "deal_id")
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Setter
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    @Setter
    private BigDecimal discountValue;

    @MapsId // 이 부분을 넣어야 deal_discount 의 deal_id 가 FK 가 된다.
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "deal_id")
    private Deal deal;

    public void setDeal(Deal deal) {
        this.deal = deal;
        deal.setDealDiscount(this);
    }
}
