package com.snumbers.bdpickupws.security;

import com.snumbers.bdpickupws.SpringApplicationContext;

public class SecurityConstants {
    static AppProperties appProperties = (AppProperties) SpringApplicationContext.getBeans("appProperties");

    public static final long TOKEN_EXPIRATION_TIME = 600000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static String getTokenSecret() {
        return appProperties.getTokenSecret();
    }
}
