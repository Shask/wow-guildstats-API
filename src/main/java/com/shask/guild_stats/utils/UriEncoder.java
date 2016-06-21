package com.shask.guild_stats.utils;

import com.shask.guild_stats.api_client.WowProgressClient;

/**
 * Created by Steven Fougeron on 21/06/16.
 */
public class UriEncoder {

    private static final String mark = "-_.!~*'()\"";

    public enum Format {
        WOW_PROGRESS, BATTLE_NET
    }

    public enum Field {
        REALM, GUILD_NAME
    }

    public static String encodeURI(String argString, Format format,Field field) {
        StringBuilder uri = new StringBuilder();


        char[] chars = argString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z') || mark.indexOf(c) != -1) {
                uri.append(c);
            } else {
                uri.append(encodeChar(c, format,field));
            }
        }
        return uri.toString();
    }

    private static String encodeChar(char c, Format format,Field field) {
        String returnVal = String.valueOf(c);
        switch (format) {
            case BATTLE_NET:
                if (c == ' ') returnVal = "%20";
                break;
            case WOW_PROGRESS:
                switch (field) {
                    case REALM:
                        if (c == ' ') returnVal = "-";
                        break;
                    case GUILD_NAME:
                        if (c == ' ') returnVal = "+";
                        break;
                    default:
                }
                break;
            default:
        }
    return returnVal;
    }
}
