package com.example.core.Order;

import com.example.core.discount.FixDiscountPolicy;
import com.example.core.member.Grade;
import com.example.core.member.Member;
import com.example.core.member.MemoryMemberRepository;
import com.example.core.order.Order;
import com.example.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 1000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
