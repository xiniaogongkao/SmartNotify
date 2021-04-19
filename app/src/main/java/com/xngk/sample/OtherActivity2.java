package com.xngk.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xngk.notify.SmartNotify;
import com.xngk.notify.core.RefreshItem;

public class OtherActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);


        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmartNotify.getImpl().postNotify(RefreshItem.createNeedRefreshItem("list2"));
                finish();
            }
        });

        findViewById(R.id.test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmartNotify.getImpl().postNotify(RefreshItem.createNotNeedRefreshItem("list2"));
                finish();
            }
        });

    }

    public static void start(Context context) {
        Intent starter = new Intent(context, OtherActivity2.class);
        context.startActivity(starter);
    }
}