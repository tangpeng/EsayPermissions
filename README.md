# 如果您觉得本项目对你有用，请随手star，谢谢

# EsayPermissions
6.0 权限适配框架，一句代码搞定  

项目详解：https://www.jianshu.com/p/52795b5dab3a

在项目build.gradle文件中添加
compile 'com.apeng:EsayPermissions:1.0.0'

在需要权限判断的地方添加一下代码即可
```
    public void requestPermission(View view) {
        EsayPermissions.with(this)
                .constantRequest() //可设置被拒绝后继续申请，直到用户授权或者永久拒绝
//                .permission(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES) //支持请求6.0悬浮窗权限8.0请求安装权限
                .permission(Permission.READ_EXTERNAL_STORAGE,Permission.CAMERA)
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {
                        if (isAll) {
                            Tools.showToast(context,"获取权限成功");
                        }else {
                            Tools.showToast(context,"获取权限成功，部分权限未正常授予");
                        }
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        if(quick) {
                            Tools.showToast(context,"被永久拒绝授权，请手动授予权限");
                            //如果是被永久拒绝就跳转到应用权限系统设置页面
                            EsayPermissions.gotoPermissionSettings(context);
                        }else {
                            Tools.showToast(context,"获取权限失败");
                        }
                    }
                });
    }
```
[andorid开源项目如何提交到 jcenter，史上最详细图文讲解](https://www.jianshu.com/p/aa5532e3a586)

