package com.snumbers.pickupws.security;

import com.snumbers.pickupws.SpringApplicationContext;

public class SecurityConstants {
    static AppProperties appProperties = (AppProperties) SpringApplicationContext.getBeans("appProperties");

    public static final long TOKEN_EXPIRATION_TIME = 60000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static String getTokenSecret() {
        return appProperties.getTokenSecret();
    }

    public static final Long getTokenExpirationTime() {
        // Time is in millisecond
        String tokenExpiryTime = appProperties.getTokenExpirationTime();

        if (tokenExpiryTime != null && !tokenExpiryTime.isEmpty())
            return Long.valueOf(tokenExpiryTime);
        return TOKEN_EXPIRATION_TIME;
    }

}
