# APIS 不要忘记安装gson依赖，可参照项目内的 build.gradle脚本，或者使用android studio来引入gson

## 里面一共有三个module,但是只有app和imagedownload有用，请忽略imageupload

## 接口全在第一个module(app)的android_client内，把这个文件夹拷贝出来直接调用即可，接口返回参数基本为ResponseObject除了下载图片的接口返回Bitmap。 ResponseObject是后端返回值的反序列化，可直接作为对象使用。

## 创建两个module的目的是演示每一个接口的使用方法

## module app 使用方法：

**不要忘记login**, 所有的接口参数都写死了，只是用来演示。 接口调用后的返回值在logcat里面，注意filter设置的tag为my

## module imagedownload。所有的上传接口均上传下载下来的那张图，因此调用上传接口前必须调用下载接口
**这个module里面懒得写login接口，因此在调用上传接口前要吧这个module里面的android_client的Requests里面的token值更新，具体做法是用postman调用signin接口，获取cookie，拿到最新的token值**
这个module都是涉及到图片的上传和下载，代码写的稀巴烂
