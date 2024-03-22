package com.shinoaki.afdian.api;

import com.shinoaki.afdian.config.TokenConfig;
import com.shinoaki.afdian.model.RequestBody;
import com.shinoaki.afdian.model.request.order.QueryOrder;
import com.shinoaki.afdian.model.PageData;
import com.shinoaki.afdian.model.response.order.OrderList;
import com.shinoaki.afdian.utils.ApiUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;

public class ApiOrder {
    private ApiOrder() {

    }

    /**
     * 查询订单
     *
     * @param order 订单请求参数
     * @return 订单信息
     * @throws IOException          网络或json解析异常
     * @throws InterruptedException io线程异常
     */
    public static PageData<OrderList> queryOrder(QueryOrder order) throws IOException, InterruptedException {
        var uri = URI.create(TokenConfig.HOME + "/api/open/query-order");
        var data = ApiUtils.send(HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(new RequestBody<>(order).toJson())));
        if (data.getEc() != 200) {
            throw new IOException(STR."请求业务码异常code=\{data.getEc()} msg:\{data.getEm()}");
        }
        return PageData.to(data.getData());
    }
}
