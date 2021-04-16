package com.xngk.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xngk.notify.core.ObjNotify;
import com.xngk.notify.core.RefreshItem;

public class OtherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);


        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjNotify.getImpl().notifyRefresh(RefreshItem.createNeedRefreshItem("list"));
                finish();
            }
        });

        findViewById(R.id.test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjNotify.getImpl().notifyRefresh(RefreshItem.createNotNeedRefreshItem("list"));
                finish();
            }
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, OtherActivity.class);
        context.startActivity(starter);
    }
}