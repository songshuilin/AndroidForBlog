package com.example.edu.androidforselfweiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/10/8.
 */

public class MyView extends View {
    private Paint mPaint;//声明画笔
    private int text_color;
    private float text_size;
    private String text_content;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        int count = ta.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = ta.getIndex(i);
            switch (attr) {
                case R.styleable.MyView_text_color:
                    //这个方法就是获取属性对应的值
                    text_color = ta.getColor(attr, 10);//attr就是你属性对应的id，10是默认值，可随意写
                    break;
                case R.styleable.MyView_text_size:
                    //这个方法就是获取属性对应的值
                    text_size = ta.getFloat(attr, 10);//attr就是你属性对应的id，10是默认值，可随意写
                    break;
                case R.styleable.MyView_text_content:
                    //这个方法就是获取属性对应的值
                    text_content = ta.getString(attr);//attr就是你属性对应的id
                    break;
            }
        }

        /**
         * 初始化笔的一些属性
         */
        mPaint=new Paint();
        mPaint.setStyle(Paint.Style.STROKE);//设置笔是线条样式
        mPaint.setTextSize(text_size);//设置文本大小，就用我们自定义的
        mPaint.setColor(text_color);//设置笔的颜色，就用我们自定义的颜色
    }

    //界面更新时调用
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text_content,100,100,mPaint);//
    }

  //绘制我们的自定义view的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width=measureSpec(200,widthMeasureSpec);
        int height=measureSpec(200,heightMeasureSpec);
        setMeasuredDimension(width,height);
    }

    private int measureSpec(int i, int widthMeasureSpec) {
        int result=0;
      int mode=  MeasureSpec.getMode(widthMeasureSpec);
      int size=MeasureSpec.getSize(widthMeasureSpec);
        if (mode==MeasureSpec.EXACTLY){
            result=size;
        }else {
            result=i;
            if (mode==MeasureSpec.AT_MOST){
                result=Math.min(size,i);
            }
        }
        return  result;
    }
}
