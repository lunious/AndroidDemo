package bwf.androiddemos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Lizhangfeng on 2016/11/21 0021.
 * Description:
 */

public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private float oldX, oldY;
    private float newX, newY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //获取按下时候的坐标
                oldX = ev.getX();
                oldY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //获取移动时候的坐标
                newX = ev.getX();
                newY = ev.getY();

                int cur_X = (int) (newX - oldX);
                int cur_Y = (int) (newY - oldY);

                if (Math.abs(cur_Y) - Math.abs(cur_X) < 100) {//有水平滑动意向传递给字VIew
                    return false;
                }

                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return super.onInterceptTouchEvent(ev);
    }
}
