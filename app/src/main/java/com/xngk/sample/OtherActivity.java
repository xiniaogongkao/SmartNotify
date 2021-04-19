package com.xngk.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xngk.notify.SmartNotify;
import com.xngk.notify.core.RefreshItem;
import com.xngk.notify.listener.ObjNotifyListener;

public class OtherActivity extends AppCompatActivity {

    private final ObjNotifyListener<RefreshItem> mStringObjNotifyListener = new ObjNotifyListener<RefreshItem>() {
        @Override
        public void onNotify(RefreshItem data) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < 1000000000; i++) {
                                Log.w("test_tag", "==== i:" + i);
                            }
                        }
                    }
            ).start();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);

        SmartNotify.getImpl().registerReceiverNotify("list2", mStringObjNotifyListener);


        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmartNotify.getImpl().postNotify(RefreshItem.createNeedRefreshItem("list"));
                finish();
            }
        });

        findViewById(R.id.test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmartNotify.getImpl().postNotify(RefreshItem.createNotNeedRefreshItem("list"));
                finish();
            }
        });

        OtherActivity2.start(OtherActivity.this);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, OtherActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SmartNotify.getImpl().unRegisterReceiverNotify("list2");
    }
}