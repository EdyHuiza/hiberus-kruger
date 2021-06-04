package com.hiberus.kruger.hiberuskrugerapp.util;

public enum BundleTag {
    CARD("CARD");
    private final String value;

    BundleTag(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
