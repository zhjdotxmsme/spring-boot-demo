package com.example.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;


/**
 * @author hongjin.zhu
 * @description
 * @date 2019年01月23日 14:40
 * @modified By
 */
public class ApiGatewayVertical extends AbstractVerticle {

    @Override
    public void start(Future<Void> future) throws Exception {
        super.start(future);

        //获取端口和 ip
        String host = config().getString("api.gateway.http.address","localhost");
        int port = config().getInteger("api.gateway.http.port",9999);

        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

//        router.get("/api/v").handler(this::apiVersion);
    }
}
