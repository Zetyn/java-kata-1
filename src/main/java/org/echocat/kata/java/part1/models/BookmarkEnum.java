package org.echocat.kata.java.part1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BookmarkEnum {
    @JsonProperty("inThePlans")
    IN_THE_PLANS,
    @JsonProperty("thrown")
    THROWN,
    @JsonProperty("read")
    READ,
    @JsonProperty("favorite")
    FAVORITE,
    @JsonProperty("iRead")
    I_READ;
}
