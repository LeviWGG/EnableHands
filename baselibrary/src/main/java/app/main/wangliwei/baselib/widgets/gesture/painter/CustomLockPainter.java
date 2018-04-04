package app.main.wangliwei.baselib.widgets.gesture.painter;

import android.graphics.Canvas;
import android.graphics.Paint;

import app.main.wangliwei.baselib.R;
import app.main.wangliwei.baselib.utils.ViewUtil;
import app.main.wangliwei.baselib.widgets.gesture.model.Point;

public class CustomLockPainter extends Painter {

    @Override
    public void drawNormalPoint(Point point, Canvas canvas, Paint normalPaint) {
        normalPaint.setStyle(Paint.Style.STROKE);
        normalPaint.setStrokeWidth(point.radius / 30.0F);
        normalPaint.setColor(ViewUtil.getResourceColor(R.color.Color_343B49));
        canvas.drawCircle(point.x, point.y, point.radius, normalPaint);
    }

    @Override
    public void drawPressPoint(Point point, Canvas canvas, Paint pressPaint) {
        // 1.绘制实心点
        pressPaint.setStyle(Paint.Style.FILL);
        pressPaint.setColor(ViewUtil.getResourceColor(R.color.Color_F2AD3E));
        canvas.drawCircle(point.x, point.y, point.radius / 3.0F, pressPaint);
        // 2.绘制圆形轮廓边界
        pressPaint.setStyle(Paint.Style.STROKE);
        pressPaint.setStrokeWidth(point.radius / 20.0F);
        canvas.drawCircle(point.x, point.y, point.radius, pressPaint);
    }

    @Override
    public void drawErrorPoint(Point point, Canvas canvas, Paint errorPaint) {

    }
}
