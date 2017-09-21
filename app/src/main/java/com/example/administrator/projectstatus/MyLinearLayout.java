package com.example.administrator.projectstatus;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Administrator on 2017/9/20.
 */

public class MyLinearLayout extends LinearLayout{
    private static final String TAG = "MyLinearLayout";
    private boolean flag = false;
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final TextView title = (TextView)getChildAt(0);
        int lines = title.getLineCount();
        Log.e(TAG,"count:"+title.getLineCount());
        if(flag){
            return;
        }
        flag = true;
        if(lines > 1){
            title.setMaxLines(1);
            title.setEllipsize(TextUtils.TruncateAt.END);
        }else{
            ViewGroup.LayoutParams layoutParams = title.getLayoutParams();

            layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            title.setLayoutParams(new LinearLayout.LayoutParams(layoutParams.height,layoutParams.width));
        }

    }


}
