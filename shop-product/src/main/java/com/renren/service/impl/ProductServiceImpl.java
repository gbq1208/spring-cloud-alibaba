package com.renren.service.impl;

import com.renren.dao.ProductDao;
import com.renren.domain.Product;
import com.renren.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {
        Optional<Product> product = productDao.findById(pid);
        return product.orElse(null);
    }
}
