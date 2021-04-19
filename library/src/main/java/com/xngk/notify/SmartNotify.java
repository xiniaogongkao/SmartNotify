package com.xngk.notify;

import android.text.TextUtils;

import com.xngk.notify.core.AbsNotifyItem;
import com.xngk.notify.core.NotifyDispatch;
import com.xngk.notify.listener.ObjNotifyListener;

/**
 * @author xingwei.huang (xwdz9989@gmail.com)
 * @since v1.0.0
 */
public class SmartNotify {

    public static final String TAG = SmartNotify.class.getSimpleName();


    private static class Holder {
        public static SmartNotify sSmartNotify = new SmartNotify();
    }

    public static SmartNotify getImpl() {
        return Holder.sSmartNotify;
    }


    private NotifyDispatch mNotifyDispatch;

    private SmartNotify() {
        mNotifyDispatch = new NotifyDispatch();
    }


    public void postNotify(AbsNotifyItem absNotifyItem) {
        _Notify(absNotifyItem.getKey(), absNotifyItem);
    }

    public void registerReceiverNotify(String key, ObjNotifyListener objNotifyListener) {
        if (objNotifyListener == null || TextUtils.isEmpty(key)) {
            return;
        }
        mNotifyDispatch.registerReceiverNotify(key, objNotifyListener);
    }


    public void unRegisterReceiverNotify(String key) {
        mNotifyDispatch.unRegisterReceiverNotify(key);
    }


    public void _Notify(String key, AbsNotifyItem absNotifyItem) {
        if (TextUtils.isEmpty(key)) {
            return;
        }

        if (absNotifyItem == null) {
            return;
        }

        mNotifyDispatch._Notify(key, absNotifyItem);
    }

}
