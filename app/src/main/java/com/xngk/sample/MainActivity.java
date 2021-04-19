package com.xngk.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xngk.notify.SmartNotify;
import com.xngk.notify.core.RefreshItem;
import com.xngk.notify.listener.ObjNotifyListener;


public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    private final ObjNotifyListener<RefreshItem> mObjNotifyListener = new ObjNotifyListener<RefreshItem>() {
        @Override
        public void onNotify(RefreshItem data) {
            Log.w("test_end", "data:" + data.toString());
            if (data.isNeedRefresh()) {
                mTextView.setText("需要刷新");
            } else {
                mTextView.setText("不需要刷新");
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text);

        SmartNotify.getImpl().registerReceiverNotify("list", mObjNotifyListener);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherActivity.start(MainActivity.this);
            }
        });
    }
}