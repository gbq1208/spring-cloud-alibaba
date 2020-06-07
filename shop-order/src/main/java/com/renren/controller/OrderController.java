package com.renren.controller;

import com.alibaba.fastjson.JSON;
import com.renren.domain.Order;
import com.renren.domain.Product;
import com.renren.service.OrderService;
import com.renren.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.OrientationRequested;
import java.util.List;
import java.util.Random;

//@RestController
@Slf4j
public class OrderController {

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

        // 下单
        Order order = new Order();
        order.setUid(1);
        order.setUsername("user1");

        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);

        orderService.createOrder(order);

        log.info("create order success, content {}", JSON.toJSONString(order));

        return order;
    }

//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
////        log.info("接到{}号商品的下单请求，接下来调用商品微服务查询此商品信息", pid);
////        Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
////        log.info("查询到{}号商品的信息，内容是{}", pid, JSON.toJSONString(product));
//        Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
//
//        // 下单
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("user1");
//
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.createOrder(order);
//
//        log.info("create order success, content {}", JSON.toJSONString(order));
//
//        return order;
//    }

//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
////        log.info("接到{}号商品的下单请求，接下来调用商品微服务查询此商品信息", pid);
////        Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
////        log.info("查询到{}号商品的信息，内容是{}", pid, JSON.toJSONString(product));
//
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        ServiceInstance instance = instances.get(0);
//
//        Product product = restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + pid, Product.class);
//
//        // 下单
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("user1");
//
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.createOrder(order);
//
//        log.info("create order success, content {}", JSON.toJSONString(order));
//
//        return order;
//    }

//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接到{}号商品的下单请求，接下来调用商品微服务查询此商品信息", pid);
//        Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
//        log.info("查询到{}号商品的信息，内容是{}", pid, JSON.toJSONString(product));
//
//        // 下单
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("user1");
//
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.createOrder(order);
//
//        log.info("create order success, content {}", JSON.toJSONString(order));
//
//        return order;
//    }
}
