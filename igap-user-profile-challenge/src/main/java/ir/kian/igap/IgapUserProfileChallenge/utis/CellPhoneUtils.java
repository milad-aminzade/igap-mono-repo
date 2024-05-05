package ir.kian.igap.IgapUserProfileChallenge.utis;


import ir.kian.igap.IgapUserProfileChallenge.exception.MobileInvalidException;

import java.util.regex.Pattern;

public class CellPhoneUtils {
    private static final Pattern mobileExtendedFormat = Pattern.compile("^\\+989\\d{9}$");
    private static final Pattern mobileShortFormat = Pattern.compile("^09\\d{9}$");
    private static final Pattern mobileIncompleteFormat = Pattern.compile("^9\\d{9}$");

    public static String toStandard(String mobileNumber) {
        if (mobileExtendedFormat.matcher(mobileNumber).matches())
            return "0" + mobileNumber.substring(3);
        if (mobileShortFormat.matcher(mobileNumber).matches())
            return mobileNumber;
        if (mobileIncompleteFormat.matcher(mobileNumber).matches())
            return "0" + mobileNumber;
        throw new MobileInvalidException();
    }

}