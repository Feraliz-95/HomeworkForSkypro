package org.skypro.skyshop.exceptions;

public class ShopError {
    private final String code;
    private final String message;

    public ShopError(String code, String message) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Code cannot be null or blank");
        }
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}