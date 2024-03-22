package com.shinoaki.afdian.model.request.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 查询订单
 */
@Data
public class QueryOrder {
    /**
     * 按页数倒序获取订单，按订单创建时间倒序
     */
    @JsonProperty("page")
    private final int page;
    /**
     * 默认50，支持1-100
     */
    @JsonProperty("per_page")
    private int perPage = 50;
    /**
     * 指定订单号查询信息，如需要查多个，则英文逗号分隔
     */
    @JsonProperty("out_trade_no")
    private String outTradeNo;


}
