package com.baeksupervisor.jpademo.model.view;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Seunghyun.Baek
 * Since 2020/03/01
 */
@Data
public class DealOptionView {
    private Long id;
    private String label;
    private String attribute;
    private BigDecimal price;
    private int stock;
}
