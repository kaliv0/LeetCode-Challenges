/*
    TinyURL is a URL shortening service where you enter a URL
    such as https://leetcode.com/problems/design-tinyurl
    and it returns a short URL such as http://tinyurl.com/4e9iAk.

    Design a class to encode a URL and decode a tiny URL.
    There is no restriction on how your encode/decode algorithm should work.
    You just need to ensure that a URL can be encoded to a tiny URL
    and the tiny URL can be decoded to the original URL.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {
    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        Codec codec = new Codec();
        String encodedUr = codec.encode(url);
        String decodedUr = codec.decode(encodedUr);
        System.out.println(encodedUr);
        System.out.println(decodedUr);
    }
}

class Codec {
    private final Map<String, String> urls = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String randomUrl = this.generateRandomString();
        this.urls.put(randomUrl, longUrl);
        return randomUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return this.urls.getOrDefault(shortUrl, "No url found");
    }

    private String generateRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int randomStringLength = 6;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(randomStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
