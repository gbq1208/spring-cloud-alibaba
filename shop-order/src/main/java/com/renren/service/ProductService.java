package com.renren.service;

import com.renren.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-product")// value勇于指定调用nacos下的哪个微服务
public interface ProductService {

    // @FeignClient的value + @RequestMapping的value值  骑士就是完成的请求地址 "http://service-product/product/" + pid
    @RequestMapping("/product/{pid}")// 指定请求的URI部分
    Product findByPid(@PathVariable Integer pid);
}
