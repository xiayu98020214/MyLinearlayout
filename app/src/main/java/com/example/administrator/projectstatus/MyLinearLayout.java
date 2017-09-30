package com.example.administrator.projectstatus;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Administrator on 2017/9/20.
 */

public class MyLinearLayout extends LinearLayout{
    private static final String TAG = "MyLinearLayout";
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewTreeObserver obs = getViewTreeObserver();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    obs.removeOnGlobalLayoutListener(this);
                } else {
                    obs.removeGlobalOnLayoutListener(this);
                }
                Log.d(TAG, "onGlobalLayout: ");
                final TextView title = (TextView)getChildAt(0);
                int lines = title.getLineCount();
                Log.e(TAG,"count:"+title.getLineCount());

                if(lines > 1){
                    title.setMaxLines(1);
                    title.setEllipsize(TextUtils.TruncateAt.END);
                }else{
                    ViewGroup.LayoutParams layoutParams = title.getLayoutParams();

                    layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                    title.setLayoutParams(new LinearLayout.LayoutParams(layoutParams.height,layoutParams.width));
                }
            }
        });
    }

}
