package app.main.wangliwei.baselib.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wlw on 2018/4/10.
 */

public final class TextUtil {
    /**
     * 格式化银行卡号
     *
     * @param bankcardNumber
     * @return
     */
    public static String formatBankcardNumber(String bankcardNumber) {
        if (TextUtils.isEmpty(bankcardNumber)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int splitNumber = 0;
        for (int i = 0; i < bankcardNumber.length(); i++) {
            stringBuilder.append(bankcardNumber.charAt(i));
            splitNumber++;
            if (splitNumber == 4) {
                stringBuilder.append(" ");
                splitNumber = 0;
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 隐藏手机号
     *
     * @param mobile
     * @return
     */
    public static String hideMobile(String mobile) {
        if (TextUtils.isEmpty(mobile)) {
            return "";
        }
        if (mobile.length() == 11) {
            return mobile.substring(0, 3) + "****" + mobile.substring(mobile.length() - 4, mobile.length());
        } else {
            return mobile;
        }
    }

    /**
     * 判定是否8位以内数字
     *
     * @param number
     * @return
     */
    public static boolean isNumber(float number) {
        Pattern patternNumber = Pattern.compile("^([0-9]+(.[0-9]{1,8})?)$");
        Matcher matcherNumber = patternNumber.matcher(String.valueOf(number));
        boolean bNumber = matcherNumber.matches();
        return bNumber;
    }

    /**
     * 判定密码是否符合8-20位非纯数字字符，不含特殊字符
     *
     * @param password
     * @return
     */
    public static boolean isillegal(String password) {
        Pattern patternNumber = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[a-zA-Z0-9]{8,20}");
        Matcher matcherNumber = patternNumber.matcher(password);
        return !matcherNumber.matches();
    }
}
