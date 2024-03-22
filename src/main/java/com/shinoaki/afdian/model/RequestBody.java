package com.shinoaki.afdian.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.shinoaki.afdian.config.TokenConfig;
import com.shinoaki.afdian.utils.JsonUtils;
import com.shinoaki.afdian.utils.SignUtils;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
public class RequestBody<T> {
    @JsonProperty("user_id")
    private final String userId;
    @JsonIgnore
    private T data;
    @JsonProperty("params")
    private String params;
    @JsonProperty("ts")
    private final long ts;
    @JsonProperty("sign")
    private String sign;

    public RequestBody(T params) {
        var config = getConfig();
        this.userId = config.userId();
        this.data = params;
        this.ts = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(+8));
        var r = SignUtils.sign(config, params, this.ts);
        this.params = r.key();
        this.sign = r.value();
    }

    public String toJson() throws JsonProcessingException {
        return new JsonUtils().toJson(this);
    }

    private TokenConfig getConfig() {
        var config = TokenConfig.getInstance();
        if (config == null) {
            throw new RuntimeException("请先添加user_id和token");
        }
        return config;
    }
}
