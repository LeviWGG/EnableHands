package app.main.wangliwei.baselib.widgets.gesture.model;


public class Point {

    public static final int POINT_NORMAL_STATUS = 0x0001; // 正常状态
    public static final int POINT_PRESS_STATUS = 0x0002; // 按下状态
    public static final int POINT_ERROR_STATUS = 0x0003; // 出错状态

    /**
     * 单位点的圆心坐标和半径
     */
    public int x;
    public int y;
    public int radius;

    /**
     * 点状态
     */
    public int status;

    /**
     * 点下标 (取值范围[0,8]，用于解锁完成后把手势密码转换成数字密码)
     */
    public int index;

}
