package com.shinoaki.afdian.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfo {
    /**
     * 用户唯一ID
     */
    @JsonProperty("user_id")
    private String userId;
    /**
     * 昵称，非唯一，可重复
     */
    @JsonProperty("name")
    private String name;
    /**
     * 头像
     */
    @JsonProperty("avatar")
    private String avatar;
}
