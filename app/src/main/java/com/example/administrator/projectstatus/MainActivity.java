package com.example.administrator.projectstatus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView mTitle;
    private TextView mStatus;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTitle= (TextView)findViewById(R.id.title);
        mStatus=(TextView)findViewById(R.id.status);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mTitle.post(new Runnable() {
            @Override
            public void run() {
                int lines = mTitle.getLineCount();
                Log.e(TAG,"count:"+mTitle.getLineCount());

                if(lines > 1){
                    mTitle.setMaxLines(1);
                    mTitle.setEllipsize(TextUtils.TruncateAt.END);
                }else{
                    ViewGroup.LayoutParams layoutParams = mTitle.getLayoutParams();

                    layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                    mTitle.setLayoutParams(new LinearLayout.LayoutParams(layoutParams.height,layoutParams.width));
                }
            }
        });
    }


}
