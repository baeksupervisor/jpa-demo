package com.baeksupervisor.jpademo.model.view;

import com.baeksupervisor.jpademo.model.DiscountType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Seunghyun.Baek
 * Since 2020/03/01
 */
@Data
public class DealDiscountView implements Serializable {
    private DiscountType discountType;
    private BigDecimal discountPrice;
}
