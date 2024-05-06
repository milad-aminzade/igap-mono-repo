package ir.kian.igap.IgapUserProfileChallenge.utis;

import ir.kian.igap.IgapUserProfileChallenge.exception.MaxRandomLengthException;
import ir.kian.igap.common.utils.BaseUtil;

import java.util.Random;

public class SequenceGeneratorUtils extends BaseUtil {
    public static String generateAlphaNumerics(int length) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String generateNumerics(int length) {
        if (length > 9 || length < 1)
            throw new MaxRandomLengthException();
        int minBound = (int) Math.pow(10, length - 1);
        int maxBound = 10 * minBound - 1;
        int result = new Random().nextInt(minBound, maxBound);
        return String.valueOf(result);
    }
}
