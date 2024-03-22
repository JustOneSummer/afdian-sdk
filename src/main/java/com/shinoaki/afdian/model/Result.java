package com.shinoaki.afdian.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class Result {

    private int ec;
    private JsonNode data;
    private String em;
}
