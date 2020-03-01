package com.baeksupervisor.jpademo.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seunghyun.Baek
 * Since 2020/03/01
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "name", length = 100)
    private String name;

    private BigDecimal sellPrice;

    private int stock;

    @OneToOne(mappedBy = "deal", fetch = FetchType.EAGER, orphanRemoval = true)
    private DealDiscount dealDiscount;

    @OneToMany(mappedBy="deal", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<DealOptionSelect> options = new ArrayList<DealOptionSelect>();

    public void addOption(DealOptionSelect option) {
        if (this.options == null) {
            this.options = new ArrayList<>();
        }
        this.options.add(option);
    }
}
