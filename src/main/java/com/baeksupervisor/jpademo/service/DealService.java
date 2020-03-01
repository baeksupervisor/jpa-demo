package com.baeksupervisor.jpademo.service;

import com.baeksupervisor.jpademo.model.DiscountType;
import com.baeksupervisor.jpademo.model.OptionSelectType;
import com.baeksupervisor.jpademo.persistence.Deal;
import com.baeksupervisor.jpademo.persistence.DealDiscount;
import com.baeksupervisor.jpademo.persistence.DealOptionSelect;
import com.baeksupervisor.jpademo.repository.DealDiscountRepository;
import com.baeksupervisor.jpademo.repository.DealOptionSelectRepository;
import com.baeksupervisor.jpademo.repository.DealRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Seunghyun.Baek
 * Since 2020/03/01
 */
@Service
public class DealService {
    private final DealRepository dealRepository;
    private final DealDiscountRepository dealDiscountRepository;
    private final DealOptionSelectRepository dealOptionSelectRepository;

    public DealService(DealRepository dealRepository, DealDiscountRepository dealDiscountRepository, DealOptionSelectRepository dealOptionSelectRepository) {
        this.dealRepository = dealRepository;
        this.dealDiscountRepository = dealDiscountRepository;
        this.dealOptionSelectRepository = dealOptionSelectRepository;
    }

    @Transactional
    public void init() {
        for (int i=0 ; i<10 ; i++) {
            Deal deal = new Deal();
            deal.setName("테스트 상품 "+(i+1));
            deal.setSellPrice(BigDecimal.valueOf(10000L).multiply(BigDecimal.valueOf((i+1))));
            deal.setStock(i+1);

            if (i%3 == 0) {
                DealDiscount dealDiscount = new DealDiscount();
                dealDiscount.setDiscountType(DiscountType.FIXED_RATE);
                dealDiscount.setDiscountValue(BigDecimal.valueOf(0.1d));
                dealDiscount.setDeal(deal);
                dealDiscountRepository.save(dealDiscount);
            }

            if (i%5 == 0) {
                DealOptionSelect option1 = new DealOptionSelect(OptionSelectType.COLOR, "색상", "빨강", "#ff0000");
                option1.setDeal(deal);
                dealOptionSelectRepository.save(option1);

                DealOptionSelect option2 = new DealOptionSelect(OptionSelectType.COLOR, "색상", "파랑", "#0000ff");
                option2.setDeal(deal);
                dealOptionSelectRepository.save(option2);
            }

            dealRepository.save(deal);
        }
    }

    public List<Deal> findAll() {
        return dealRepository.findAll();
    }

    public void deleteOne(Long dealId) {
        dealRepository.deleteById(dealId);
    }
}
