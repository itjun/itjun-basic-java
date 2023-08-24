package io.itjun.basic.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

class URLEncodingExample {

    // Method to encode a string value using `UTF-8` encoding scheme
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    private static String dncodeValue(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    public static void main(String[] args) {
        String baseUrl = "https://www.google.com/search?q=";

        String query = "Hello World@Java";
        String encodedQuery = encodeValue(query); // Encoding a query string

        String completeUrl = baseUrl + encodedQuery;
        System.out.println(completeUrl);

        System.out.println(dncodeValue(encodedQuery));

    }
}