package com.xngk.notify;

import android.text.TextUtils;

import com.xngk.notify.core.AbsNotifyItem;
import com.xngk.notify.core.NotifyDispatch;
import com.xngk.notify.listener.ObjNotifyListener;

/**
 * @author xingwei.huang (xwdz9989@gmail.com)
 * @since v1.0.0
 */
public class ObjNotify {

    public static final String TAG = ObjNotify.class.getSimpleName();


    private static class Holder {
        public static ObjNotify sObjNotify = new ObjNotify();
    }

    public static ObjNotify getImpl() {
        return Holder.sObjNotify;
    }


    private NotifyDispatch mNotifyDispatch;

    private ObjNotify() {
        mNotifyDispatch = new NotifyDispatch();
    }


    public void notifyRefresh(AbsNotifyItem absNotifyItem) {
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
