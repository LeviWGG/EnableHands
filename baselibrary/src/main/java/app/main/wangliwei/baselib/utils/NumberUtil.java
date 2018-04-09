package app.main.wangliwei.baselib.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class NumberUtil {

    /**
     * 取整
     *
     * @param number
     * @return
     */
    public static String toIntAndFormat(String number) {
        String style = "#,##0";
        DecimalFormat df = new DecimalFormat(style);
        return df.format(_toInt(number));
    }

    /**
     * 保留两位小数并格式化
     *
     * @param number
     * @return
     */
    public static String to2DecimalAndFormat(String number) {
        String style = "#,##0.00";
        DecimalFormat df = new DecimalFormat(style);
        return df.format(_to2Decimal(number));
    }

    /**
     * 保留两位小数
     *
     * @param number
     * @return
     */
    public static String to2Decimal(String number) {
        String style = "0.00";
        DecimalFormat df = new DecimalFormat(style);
        return df.format(_to2Decimal(number));
    }

    /**
     * 金额转换成对应国家(默认CNY)
     *
     * @param money
     * @return
     */
    public static String moneyFormatToCountry(String money) {
        String style = "#,##0.00 CNY";
        DecimalFormat df = new DecimalFormat(style);
        return df.format(_to2Decimal(money));
    }

    /**
     * 转成8位小数(四舍五入)
     *
     * @param number 数值
     * @return
     */
    public static double _to8Decimal(String number) {
        BigDecimal b = new BigDecimal(number);
        return b.setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 转成整数
     *
     * @param number 数值
     * @return
     */
    public static double _toInt(String number) {
        BigDecimal b = new BigDecimal(number);
        return b.intValue();
    }

    /**
     * 转成2位小数(四舍五入)
     *
     * @param number 数值
     * @return
     */
    public static double _to2Decimal(String number) {
        BigDecimal b = new BigDecimal(number);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确加法计算的add方法
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确减法运算的sub方法
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double mul(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的除法运算方法div
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static double div(double value1, double value2, int scale) throws IllegalAccessException {
        //如果精确范围小于0，抛出异常信息
        if (scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.divide(b2, scale, RoundingMode.UP).doubleValue();
    }

}
