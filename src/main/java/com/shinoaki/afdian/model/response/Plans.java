package com.shinoaki.afdian.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * 赞助方案
 */
@Data
public class Plans {
    @JsonProperty("plan_id")
    private String planId;

    @JsonProperty("rank")
    private int rank;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("status")
    private int status;

    @JsonProperty("name")
    private String name;

    @JsonProperty("pic")
    private String pic;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("price")
    private String price;

    @JsonProperty("update_time")
    private long updateTime;
    @JsonProperty("pay_month")
    private int payMonth;

    @JsonProperty("show_price")
    private String showPrice;

    @JsonProperty("independent")
    private int independent;

    @JsonProperty("permanent")
    private int permanent;

    @JsonProperty("can_buy_hide")
    private int canBuyHide;

    @JsonProperty("need_address")
    private int needAddress;

    @JsonProperty("product_type")
    private int productType;

    @JsonProperty("sale_limit_count")
    private int saleLimitCount;

    @JsonProperty("need_invite_code")
    private boolean needInviteCode;

    @JsonProperty("expire_time")
    private long expireTime;

    @JsonProperty("sku_processed")
    private JsonNode skuProcessed;

    @JsonProperty("rankType")
    private String rankType;

}
