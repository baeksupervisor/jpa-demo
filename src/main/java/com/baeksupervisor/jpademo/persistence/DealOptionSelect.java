package com.baeksupervisor.jpademo.persistence;

import com.baeksupervisor.jpademo.model.DealOptionSelectStatus;
import com.baeksupervisor.jpademo.model.OptionSelectType;
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
@Setter
@NoArgsConstructor
@Entity
public class DealOptionSelect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private OptionSelectType type;

    private String label;

    private String attribute;

    private String rgb;

    @Setter
    private int initStock;

    @Setter
    private int stock;

    @Setter
    private BigDecimal price;

    @Setter
    @Enumerated(EnumType.STRING)
    private DealOptionSelectStatus status;

    @Setter
    private String managingCode;

    @Setter
    private boolean used;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "deal_id")
    private Deal deal;

    public DealOptionSelect(OptionSelectType type, String label, String attribute, String rgb) {
        this.type = type;
        this.label = label;
        this.attribute = attribute;
        this.rgb = rgb;
        this.initStock = 10;
        this.stock = 10;
        this.price = BigDecimal.ZERO;
        this.used = true;
        this.status = DealOptionSelectStatus.SALE;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
        deal.addOption(this);
    }
}
