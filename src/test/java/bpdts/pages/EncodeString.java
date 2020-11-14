package bpdts.pages;

import org.apache.commons.codec.binary.StringUtils;

public class EncodeString {

    public static String encode(String string) {
        String rawString = string;
        byte[] bytes = StringUtils.getBytesUtf8(rawString);

        return StringUtils.newStringUtf8(bytes);
    }

}
