package org.arno.shortlink.admin.toolkit;

import java.security.SecureRandom;

/**
 * 分组id随机生成器
 */
public final class RandomGenerator {
    public static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final SecureRandom RANDOM = new SecureRandom();
    public static String generateRandom() {
        return generateRandom(6);
    }
    public static String generateRandom(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
