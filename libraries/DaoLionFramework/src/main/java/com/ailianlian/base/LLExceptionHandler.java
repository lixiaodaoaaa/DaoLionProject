package com.ailianlian.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;

import java.lang.Thread.UncaughtExceptionHandler;

public class LLExceptionHandler implements UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler";
    private static LLExceptionHandler instance;
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private LLExceptionHandler(Context context) {
        init(context);
    }

    public static LLExceptionHandler getInstance(Context context) {
        if (instance == null) {
            instance = new LLExceptionHandler(context);
        }
        return instance;
    }

    private void init(Context context) {
        mContext = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        // Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        ex.printStackTrace();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);

//        if (!handleException(ex) && mDefaultHandler != null) {
//            mDefaultHandler.uncaughtException(thread, ex);
//        } else {
//            android.os.Process.killProcess(android.os.Process.myPid());
//            System.exit(10);
//        }
        /*Log.e(TAG, ex.getMessage());
        SuperToastUtil.showToast(mContext, ex.getMessage());*/
    }

    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成. 开发者可以根据自己的情况来自定义异常处理逻辑
     *
     * @param ex
     * @return true:如果处理了该异常信息;否则返回false
     */
    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return true;
        }
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                new AlertDialog.Builder(mContext).setTitle("提示").setCancelable(false)
                        .setMessage("程序崩溃了...").setNeutralButton("我知道了", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(10);
                    }
                }).create().show();
                Looper.loop();
            }
        }.start();
        return true;
    }
}