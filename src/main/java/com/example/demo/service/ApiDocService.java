package com.example.demo.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月12日 13:58
 * @modified By
 */
@Service
@SuppressWarnings("JavaDoc")
public interface ApiDocService {

    /**
     * @api {GET} /product/{id} 根据产品 ID 查询产品
     * @apiVersion 1.0.0
     * @apiGroup Product
     * @apiName getProductById
     *
     * @apiParam {Number} id 产品ID
     *
     * @apiSuccess {Product} product 产品对象
     * @apiSuccess {String} product.id 产品ID
     * @apiSuccess {String} product.name 产品名称
     * @apiSuccess {Number} product.price 产品价格
     * @apiSuccess {Number} product.created 创建时间
     *
     * @apiError 500 错误请求
     * @apiError 600 无效的产品ID
     *
     * @apiSuccessExample 输入
     * GET：product/1
     * @apiSuccessExample 输出
     * {
     *     "id":1,
     *     "name":"MacBook",
     *     "price":10000,
     *     "created":xxx
     * }
     */
    Map<String, Object> getProductById(@PathVariable("id") Long id);
}
