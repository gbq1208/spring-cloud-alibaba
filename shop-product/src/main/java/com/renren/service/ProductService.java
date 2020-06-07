package com.renren.service;

import com.renren.domain.Product;

public interface ProductService {
    Product findByPid(Integer pid);
}
