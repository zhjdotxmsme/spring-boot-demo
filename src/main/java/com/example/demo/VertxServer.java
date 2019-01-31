package com.example.demo;


import com.google.common.collect.Sets;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpConnection;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.shareddata.SharedData;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author hongjin.zhu
 * @description
 * @date 2019年01月21日 11:28
 * @modified By
 */
public class VertxServer extends AbstractVerticle {

    public static void main(String[] args) {
        VertxOptions options = new VertxOptions().setWorkerPoolSize(40);
        Vertx.vertx(options).deployVerticle(VertxServer.class.getName());
    }

    @Override
    public void start() throws Exception {
        super.start();

        CopyOnWriteArraySet<ServerWebSocket> sockets = Sets.newCopyOnWriteArraySet();
        Context context = vertx.getOrCreateContext();
        System.out.println("====" + context);
        SharedData data = vertx.sharedData();
        vertx.createHttpServer().websocketHandler(socket -> {
            String path = socket.path();
            vertx.eventBus().publish("org.alex.test","hello").consumer("org.alex.test", message -> System.out.println(message));
            if ("/app".equals(path)) {
                socket.handler(buffer -> {
                    sockets.add(socket);

                    System.out.println("============");
                    System.out.println("server收到消息: " + buffer.toString());
                    System.out.println("============");
                    for (ServerWebSocket s : sockets) {
                        Buffer b = Buffer.buffer();
                        b.appendString("aaa");
                        s.writeTextMessage(b.toString());
                        s.writeTextMessage(buffer.toString());
                    }
                });
            } else {
                socket.reject();
            }

            socket.closeHandler(c -> System.out.println("socket 关闭了"));
            socket.endHandler(end -> System.out.println("end 操作"));
            socket.exceptionHandler(ex -> System.out.println("异常打印" + ex.getMessage()));

        }).listen(10086, server -> {
            if (server.succeeded()) {
                System.out.println("启动成功");
            } else {
                server.cause().printStackTrace();
            }
        });


//        HttpServerOptions options = new HttpServerOptions()
//                .setUseAlpn(true)
//                .setSsl(true)
//                .setKeyStoreOptions(new JksOptions().setPath("/path/to/my/keystore"));

        vertx.createHttpServer().requestHandler(request ->{
            HttpConnection connection = request.connection();
            Buffer buffer = Buffer.buffer().appendString("我是心跳服务器");
            connection.ping(buffer,pong -> {
                System.out.println("客户端有回音");
            });
        }).listen(12306,httpServerAsyncResult -> {
            if (httpServerAsyncResult.succeeded()){
                System.out.println("心跳服务器启动成功");
            } else {
                httpServerAsyncResult.cause().printStackTrace();
            }
        });
    }
}
