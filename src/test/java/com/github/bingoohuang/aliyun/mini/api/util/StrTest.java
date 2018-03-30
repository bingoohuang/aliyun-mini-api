package com.github.bingoohuang.aliyun.mini.api.util;

import com.google.common.base.CharMatcher;
import lombok.val;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class StrTest {
    @Test
    public void test() {
        val r1 = Str.random(10, Str.Format.LowerCaseLetters, Str.Format.Digits, Str.Format.Underscore);
        assertThat(CharMatcher.anyOf("abcdefghijklmnopqrstuvwxyz_0123456789").matchesAllOf(r1)).isTrue();

        val r2 = Str.random(10);
        assertThat(CharMatcher.anyOf("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789").matchesAllOf(r2)).isTrue();

        val r3 = Str.random(10, Str.Format.UpperCaseLetters);
        assertThat(CharMatcher.anyOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ").matchesAllOf(r3)).isTrue();

        val r4 = Str.random(10, Str.Format.Letters);
        assertThat(CharMatcher.anyOf("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").matchesAllOf(r4)).isTrue();

        val r5 = Str.random(10, Str.Format.LetterDigits);
        assertThat(CharMatcher.anyOf("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789").matchesAllOf(r5)).isTrue();
    }
}
