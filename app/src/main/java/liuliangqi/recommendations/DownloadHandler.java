package liuliangqi.recommendations;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by liuliangqi on 2017/5/2.
 */

public class DownloadHandler extends Handler {
    private DownloadService mService;

    @Override
    public void handleMessage(Message msg) {
        String song = msg.obj.toString();
        download(song);
        mService.stopSelf(msg.arg1);
    }

    public void download(String song){
        long endtime = System.currentTimeMillis() + 10 * 1000;
        while(System.currentTimeMillis() < endtime){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("HI", "downloaded" + song);
    }

    public void setService(DownloadService service) {
        mService = service;
    }
}
