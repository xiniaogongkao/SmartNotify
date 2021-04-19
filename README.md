### SmartNotify 介绍文档


#### 前言

**SmartNotify**是一个轻量形基于事件分发的通知框架；
一般在业务开发中会有这样一种情况，A界面打开B界面,B界面操作了某些需求以后返回A界面；
这是一种很常规也很基础的业务需求，再Android端我们会选择使用`startActivityResult`来解决该问题；
不过一旦界面请求的接口较多`startActivityResult`方法会非常臃肿；类似如下

```java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        switch (requestCode){
            case  1:
                // 刷新某个接口
                break;
            case 2:
                //刷新接口
                break;
        }
    }
```
而使用`startActivityResult`比较繁琐还需要拿到`activity`。再非`activity`类里面处理起来很不方便，所以有没有一种方式像`event bus`直接可以post数据出去呢？这也是`SmartNotify`的原因



### SmartNotify Api 介绍

1. `AbsNotifyItem` 基础事件类；用于事件通讯
2. `RefreshItem` 基于`AbsNotifyItem`封装的一个刷新事件，仅仅用于是否刷新
3. `SmartNotify.getImpl().postNotify()` 发送消息
4. `SmartNotify.getImpl().registerReceiverNotify` 接受消息

#### java代码
```java
        SmartNotify.getImpl().postNotify(RefreshItem.createNeedRefreshItem("needRefreshList")); // 发送消息
       
        // 接受消息；该段代码一般存在接受消息界面
        SmartNotify.getImpl().registerReceiverNotify("needRefreshList", new SmartNotifyListener() {
            @Override
            public void onNotify(AbsNotifyItem smartItem) {
                
            }
        });
```




### SmartNotify 进阶
TODO


### 远程依赖方式
```
TODO 
```


### 维护联系
- huangxingwei@xiniaogongkao.com
