package com.shinoaki.afdian.config;

import java.util.Objects;

/**
 * api 配置
 */
public final class TokenConfig {
    private static TokenConfig TC = null;
    public static final String HOME = "https://afdian.net";
    private final String userId;
    private final String token;

    /**
     * @param userId 用户id   （https://afdian.net/dashboard/dev）查看
     * @param token  用户token
     */
    private TokenConfig(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public static TokenConfig getInstance() {
        return TC;
    }

    public static void load(String userId, String token) {
        TC = new TokenConfig(userId, token);
    }

    public String userId() {
        return userId;
    }

    public String token() {
        return token;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (TokenConfig) obj;
        return Objects.equals(this.userId, that.userId) &&
               Objects.equals(this.token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, token);
    }

    @Override
    public String toString() {
        return "TokenConfig[" +
               "userId=" + userId + ", " +
               "token=" + token + ']';
    }

}
