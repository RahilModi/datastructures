package com.datastructures.string;

import java.util.HashMap;
import java.util.Map;

public class designTinyURL {
    Map<Long, String> map = new HashMap<>();
    final String host= "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        long hash = longUrl.hashCode();
        map.put(hash, longUrl);
        return host+hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        long hashCode = Long.parseLong(shortUrl.split(host)[1]);
        return map.get(hashCode);
    }
}
