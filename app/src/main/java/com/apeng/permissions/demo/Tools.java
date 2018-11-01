package com.apeng.permissions.demo;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * ProjectName:XXPermissions-master
 * Date:2018/11/1 14:25
 *
 * @author fanqiejiang
 */

public class Tools {
    private static Toast toast;

    /**
     * 防止每一次点击,都创建一个新的,静态内部类在外面,那么activity,相当于单列模式,需要使用,context.getApplicationContext()
     *
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        if (toast != null) {
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
        } else {
            toast = Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_SHORT);
        }
        if (context != null) {
            if (context instanceof Activity && !((Activity) context).isFinishing()) {
                toast.show();
            }
        }
    }
}
