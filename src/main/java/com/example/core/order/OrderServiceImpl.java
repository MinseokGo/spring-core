package com.example.core.order;

import com.example.core.discount.DiscountPolicy;
import com.example.core.member.Member;
import com.example.core.member.MemberRespository;

public class OrderServiceImpl implements OrderService {
    private final MemberRespository memberRespository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRespository memberRespository, DiscountPolicy discountPolicy) {
        this.memberRespository = memberRespository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRespository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
