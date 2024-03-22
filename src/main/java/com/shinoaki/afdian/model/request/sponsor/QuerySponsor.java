package com.shinoaki.afdian.model.request.sponsor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuerySponsor {
    /**
     * 当前按建立关系时间倒序
     */
    @JsonProperty("page")
    private final int page;
    /**
     * 默认20，支持1-100
     */
    @JsonProperty("per_page")
    private int perPage = 20;
    /**
     * 可以查询指定用户的赞助情况，如果需要传多个请使用英文逗号分隔
     */
    @JsonProperty("user_id")
    private String userId;
}
