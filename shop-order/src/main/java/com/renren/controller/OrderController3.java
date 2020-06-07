package com.renren.controller;

import com.alibaba.fastjson.JSON;
import com.renren.domain.Order;
import com.renren.domain.Product;
import com.renren.service.OrderService;
import com.renren.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController3 {

    @RequestMapping("/order/message1")
    public String message1() {
        return "test multi-high request 1";
    }

    @RequestMapping("/order/message2")
    public String message2() {
        return "test multi-high request 2";
    }
}
