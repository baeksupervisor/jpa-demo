package com.baeksupervisor.jpademo.controller;

import com.baeksupervisor.jpademo.model.view.DealDiscountView;
import com.baeksupervisor.jpademo.model.view.DealOptionView;
import com.baeksupervisor.jpademo.model.view.DealView;
import com.baeksupervisor.jpademo.persistence.Deal;
import com.baeksupervisor.jpademo.persistence.DealDiscount;
import com.baeksupervisor.jpademo.persistence.DealOptionSelect;
import com.baeksupervisor.jpademo.service.DealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seunghyun.Baek
 * Since 2020/03/01
 */
@RequestMapping("/deals")
@RestController
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostConstruct
    void init() {
        dealService.init();
    }

    @GetMapping("")
    public ResponseEntity getDeals() {
        List<DealView> data = new ArrayList<>();
        List<Deal> deals = dealService.findAll();
        deals.forEach(o -> {
            DealView dealView = new DealView();
            dealView.setId(o.getId());
            dealView.setName(o.getName());
            dealView.setSellPrice(o.getSellPrice());
            dealView.setStock(o.getStock());

            DealDiscount discount = o.getDealDiscount();
            if (discount != null) {
                DealDiscountView discountView = new DealDiscountView();
                discountView.setDiscountType(discount.getDiscountType());
                discountView.setDiscountPrice(o.getSellPrice().multiply(discount.getDiscountValue()));
                dealView.setDiscount(discountView);
            }

            List<DealOptionSelect> options = o.getOptions();
            if (!ObjectUtils.isEmpty(options)) {
                dealView.setOptions(new ArrayList<>());
                options.stream().forEach(o2 -> {
                    DealOptionView optionView = new DealOptionView();
                    optionView.setId(o2.getId());
                    optionView.setLabel(o2.getLabel());
                    optionView.setAttribute(o2.getAttribute());
                    optionView.setPrice(o2.getPrice());
                    optionView.setStock(o2.getStock());
                    dealView.getOptions().add(optionView);
                });
            }
            data.add(dealView);
        });
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable("id") Long id) {
        dealService.deleteOne(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
