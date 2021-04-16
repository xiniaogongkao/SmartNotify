package com.xngk.notify.core;

/**
 * @author xingwei.huang (xwdz9989@gmail.com)
 * @since v1.0.0
 */
public class RefreshItem extends AbsNotifyItem {

    public static final int STATUS_NEED_REFRESH = 1;
    public static final int STATUS_NOT_REFRESH  = 0;


    public static RefreshItem createNeedRefreshItem(String key) {
        return new RefreshItem(key, STATUS_NEED_REFRESH);
    }


    public static RefreshItem createNotNeedRefreshItem(String key) {
        return new RefreshItem(key, STATUS_NOT_REFRESH);
    }


    public RefreshItem(String key, Object data) {
        super(key, data);
    }

    public boolean isNeedRefresh() {
        return STATUS_NEED_REFRESH == Integer.parseInt(String.valueOf(getData()));
    }
}
