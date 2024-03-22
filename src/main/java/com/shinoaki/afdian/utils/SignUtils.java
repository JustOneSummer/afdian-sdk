package com.shinoaki.afdian.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shinoaki.afdian.config.TokenConfig;
import com.shinoaki.afdian.model.data.KeyValue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

@Slf4j
public class SignUtils {
    private SignUtils() {

    }

    public static <T> KeyValue<String, String> sign(TokenConfig config, T params, long ts) {
        JsonUtils json = new JsonUtils();
        try {
            var data = json.toJson(params);
            return new KeyValue<>(data, DigestUtils.md5Hex(STR."\{config.token()}params\{data}ts\{ts}user_id\{config.userId()}"));
        } catch (JsonProcessingException e) {
            log.error("{} 序列化异常！", params);
        }
        return new KeyValue<>("", "");
    }
}
