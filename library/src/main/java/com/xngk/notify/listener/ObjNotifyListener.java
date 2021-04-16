package com.xngk.notify.listener;

import com.xngk.notify.core.AbsNotifyItem;

/**
 * @author xingwei.huang (xwdz9989@gmail.com)
 * @since v1.0.0
 */
public interface ObjNotifyListener<T extends AbsNotifyItem> {

    void onNotify(T data);
}
