package liuliangqi.recommendations;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by liuliangqi on 2017/5/3.
 */

public class DownloadService extends Service {
    // start service 可以一直在后台运行，直到called to  stop
    // bind service 是通过使用 service间接获取某些服务功能
    DownloadHandler mDownloadHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        DownloadThread downloadThread = new DownloadThread();
        downloadThread.setName("DownloadThread");
        downloadThread.start();
        while(downloadThread.mDownloadHandler == null){
        }
        mDownloadHandler = downloadThread.mDownloadHandler;
        mDownloadHandler.setService(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        Message message = Message.obtain();
        message.obj = song;
        message.arg1 = startId;
        mDownloadHandler.sendMessage(message);
        return Service.START_REDELIVER_INTENT;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
