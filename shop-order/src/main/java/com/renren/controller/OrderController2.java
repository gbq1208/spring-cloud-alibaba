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

//@RestController
@Slf4j
public class OrderController2 {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("Product No{} order coming...", pid);
        Product product = productService.findByPid(pid);
        log.info("Product No{} order found, content is: {}", pid, JSON.toJSONString(product));

        try {
            Thread.sleep(2000L);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // 下单
        Order order = new Order();
        order.setUid(1);
        order.setUsername("user1");

        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);

        // 为了不产生垃圾数据，暂时注释掉
//        orderService.createOrder(order);

        log.info("create order success, content {}", JSON.toJSONString(order));

        try {
            Thread.sleep(100L);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return order;
    }

    @RequestMapping("/order/message")
    public String message() {
        return "test multi-high request";
    }
}
