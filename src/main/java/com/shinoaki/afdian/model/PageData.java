package com.shinoaki.afdian.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.shinoaki.afdian.utils.JsonUtils;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.List;

@Data
public class PageData<T> {

    @JsonProperty("list")
    private List<T> list;
    @JsonProperty("total_count")
    private int totalCount;
    @JsonProperty("total_page")
    private int totalPage;

    public static <T> PageData<T> to(JsonNode node) throws JsonProcessingException {
        return new JsonUtils().parse(node.toString(), new TypeReference<PageData<T>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
    }
}
