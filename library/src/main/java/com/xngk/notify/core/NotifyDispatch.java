package com.xngk.notify.core;

import android.util.Log;

import com.xngk.notify.SmartNotify;
import com.xngk.notify.listener.ObjNotifyListener;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 通知分发中心
 *
 * @author xingwei.huang (xwdz9989@gmail.com)
 * @since v1.0.0
 */
public class NotifyDispatch {

    private ConcurrentHashMap<String, ObjNotifyListener> mNotifyItemListenerMap;

    public NotifyDispatch() {
        mNotifyItemListenerMap = new ConcurrentHashMap<>();
    }

    public void registerReceiverNotify(String key, ObjNotifyListener objNotifyListener) {
        mNotifyItemListenerMap.put(key, objNotifyListener);

    }

    public void _Notify(String key, AbsNotifyItem absNotifyItem) {
        ObjNotifyListener valueListener = mNotifyItemListenerMap.get(key);
        if (valueListener == null) {
            Log.e(SmartNotify.TAG, "请先注册该key[" + key + "]!!");
            return;
        }

        try {
            valueListener.onNotify(absNotifyItem);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void unRegisterReceiverNotify(String key) {
        mNotifyItemListenerMap.remove(key);
    }
}
