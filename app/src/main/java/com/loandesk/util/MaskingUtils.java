package com.loandesk.util;

public final class MaskingUtils {
    private MaskingUtils() {}

    public static String maskPan(String pan) {
        if (pan == null || pan.length() < 4) return "****";
        return "******" + pan.substring(pan.length() - 4);
    }

    public static String maskAadhaar(String aadhaar) {
        if (aadhaar == null || aadhaar.length() < 4) return "************";
        return "********" + aadhaar.substring(aadhaar.length() - 4);
    }
}
