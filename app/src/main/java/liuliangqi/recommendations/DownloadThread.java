package liuliangqi.recommendations;

import android.os.Looper;
import android.util.Log;

/**
 * Created by liuliangqi on 2017/5/2.
 */

public class DownloadThread extends Thread {
    public DownloadHandler mDownloadHandler;
    @Override
    public void run() {
        Looper.prepare();
        mDownloadHandler = new DownloadHandler();
        Looper.loop();
    }
}
