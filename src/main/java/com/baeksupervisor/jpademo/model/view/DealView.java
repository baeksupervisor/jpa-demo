package com.baeksupervisor.jpademo.model.view;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Seunghyun.Baek
 * Since 2020/03/01
 */
@Data
public class DealView {
    private Long id;
    private String name;
    private BigDecimal sellPrice;
    private int stock;
    private DealDiscountView discount;
    private List<DealOptionView> options;
}
