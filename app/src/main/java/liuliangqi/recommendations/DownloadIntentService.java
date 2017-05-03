package liuliangqi.recommendations;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by liuliangqi on 2017/5/3.
 */

public class DownloadIntentService extends IntentService {

    public DownloadIntentService() {
        super("DownloadIntentService");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        download(song);
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
}
