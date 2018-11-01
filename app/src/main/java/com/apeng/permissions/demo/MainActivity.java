package com.apeng.permissions.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.apeng.permissions.EsayPermissions;
import com.apeng.permissions.OnPermission;
import com.apeng.permissions.Permission;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context=MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void requestPermission(View view) {
        EsayPermissions.with(this)
                .constantRequest() //可设置被拒绝后继续申请，直到用户授权或者永久拒绝
//                .permission(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES) //支持请求6.0悬浮窗权限8.0请求安装权限
//                .permission(Permission.Group.STORAGE, Permission.Group.CALENDAR) //不指定权限则自动获取清单中的危险权限
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

    public void isHasPermission(View view) {
        if (EsayPermissions.isHasPermission(MainActivity.this, Permission.Group.STORAGE)) {
            Tools.showToast(getApplicationContext(),"已经获取到权限，不需要再次申请了");
        }else {
            Tools.showToast(getApplicationContext(),"还没有获取到权限或者部分权限未授予");
        }
    }

    public void gotoPermissionSettings(View view) {
        EsayPermissions.gotoPermissionSettings(MainActivity.this);
    }
}
