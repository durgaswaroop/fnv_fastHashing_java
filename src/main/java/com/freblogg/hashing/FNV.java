package com.freblogg.hashing;

/**
 * Created by swaroop on 04-04-2017.
 */
public class FNV {

    private static final long FNV32_OFFSET_BASIS = 2_166_136_261L;
    private static final long FNV32_PRIME = 16_777_619L;
    private static final long FNV32_MOD_POWER = (long) Math.pow(2, 32);

    // Long.Min - Long.Max + 14695981039346656037  - 1
    private static final long FNV64_OFFSET_BASIS = -3_750_763_034_362_895_579L;
    private static final long FNV64_PRIME = 1_099_511_628_211L;
    private static final long FNV64_MOD_POWER = (long) Math.pow(2, 64);

    public static String fnv132(String input) {
        return fnv132(getBytes(input));
    }

    public static String fnv132(byte[] bytes) {
        return fnv1(bytes, FNV32_OFFSET_BASIS, FNV32_PRIME, FNV32_MOD_POWER, 8);
    }

    public static String fnv1a32(String input) {
        return fnv1a32(getBytes(input));
    }

    public static String fnv1a32(byte[] bytes) {
        return fnv1a(bytes, FNV32_OFFSET_BASIS, FNV32_PRIME, FNV32_MOD_POWER, 8);
    }

    public static String fnv164(String input) {
        return fnv164(getBytes(input));
    }

    public static String fnv164(byte[] bytes) {
        return fnv1(bytes, FNV64_OFFSET_BASIS, FNV64_PRIME, FNV64_MOD_POWER, 16);
    }

    public static String fnv1a64(String input) {
        return fnv1a64(getBytes(input));
    }

    public static String fnv1a64(byte[] bytes) {
        return fnv1a(bytes, FNV64_OFFSET_BASIS, FNV64_PRIME, FNV64_MOD_POWER, 16);
    }

    private static String fnv1(byte[] bytes, long fnvOffsetBasis, long fnvPrime, long fnvModPower, int hashLength) {
        long hash = fnvOffsetBasis;
        for (byte b : bytes) {
            hash = (hash * fnvPrime) % fnvModPower;
            hash = hash ^ b;
        }
        String format = "%0" + hashLength + "x";
        return String.format(format, hash);
    }

    private static String fnv1a(byte[] bytes, long fnvOffsetBasis, long fnvPrime, long fnvModPower, int hashLength) {
        long hash = fnvOffsetBasis;
        for (byte b : bytes) {
            hash = hash ^ b;
            hash = (hash * fnvPrime) % fnvModPower;
        }
        String format = "%0" + hashLength + "x";
        return String.format(format, hash);
    }

    private static byte[] getBytes(String input) {
        byte[] bytes;
        try {
            bytes = input.getBytes("UTF-8");
        } catch (Exception e) {
            bytes = input.getBytes();
        }
        return bytes;
    }

}
