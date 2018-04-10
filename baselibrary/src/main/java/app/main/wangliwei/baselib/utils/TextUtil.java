package app.main.wangliwei.baselib.utils;

import android.text.TextUtils;

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
     * 影藏手机号
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
}
