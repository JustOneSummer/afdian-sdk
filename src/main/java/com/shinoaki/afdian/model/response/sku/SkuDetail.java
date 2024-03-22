package com.shinoaki.afdian.model.response.sku;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 售卖类型
 */
@Data
public class SkuDetail {
    @JsonProperty("sku_id")
    private String skuId;
    @JsonProperty("price")
    private String price;
    @JsonProperty("count")
    private int count;
    @JsonProperty("name")
    private String name;
    @JsonProperty("album_id")
    private String albumId;
    @JsonProperty("pic")
    private String pic;
    @JsonProperty("stock")
    private String stock;
    @JsonProperty("post_id")
    private String postId;
}
