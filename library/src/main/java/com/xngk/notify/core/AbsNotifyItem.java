package com.xngk.notify.core;

/**
 * @author xingwei.huang (xwdz9989@gmail.com)
 * @since v1.0.0
 */
public class AbsNotifyItem {


    public static AbsNotifyItem create(String tag, Object data) {
        return new AbsNotifyItem(tag, data);
    }

    private Object data;
    private String key;

    public AbsNotifyItem() {
    }

    public AbsNotifyItem(String key, Object data) {
        this.data = data;
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "NotifyItem{" +
                "data=" + data +
                ", tag=" + key +
                '}';
    }
}
