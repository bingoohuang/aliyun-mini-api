package com.github.bingoohuang.aliyun.mini.api.util;

import lombok.SneakyThrows;
import lombok.val;

import java.security.SecureRandom;

public class Str {
    @SneakyThrows
    public static byte[] utf8Bytes(String s) {
        return s.getBytes("UTF-8");
    }

    public enum Format {
        Letters,
        UpperCaseLetters,
        LowerCaseLetters,
        Digits,
        Underscore,
        LetterDigits
    }

    public static String random(int len, Format... formats) {
        val allows = new StringBuilder();
        for (val format : formats) {
            if (format == Format.LetterDigits) {
                allows.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
            } else if (format == Format.Letters) {
                allows.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
            } else if (format == Format.UpperCaseLetters) {
                allows.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            } else if (format == Format.LowerCaseLetters) {
                allows.append("abcdefghijklmnopqrstuvwxyz");
            } else if (format == Format.Digits) {
                allows.append("012345678910");
            } else if (format == Format.Underscore) {
                allows.append("_");
            }
        }
        if (allows.length() == 0) {
            allows.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_");
        }

        return random(allows.toString(), len);

    }

    public static String random(String allows, int len) {
        val m = new StringBuilder(len);

        val max = allows.length();
        val r = new SecureRandom();

        while (true) {
            char c = allows.charAt(r.nextInt(max));
            if (Character.isLetter(c)) {
                m.append(c); // make sure letter begins
                break;
            }
        }

        for (int i = 1; i < len; ++i) {
            m.append(allows.charAt(r.nextInt(max)));
        }

        return m.toString();
    }
}
