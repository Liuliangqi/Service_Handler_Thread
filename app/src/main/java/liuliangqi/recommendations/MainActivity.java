package liuliangqi.recommendations;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mDownloadButton;
    public static final String KEY_SONG = "song";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final DownloadThread downloadThread = new DownloadThread();
//        downloadThread.start();

        mDownloadButton = (Button) findViewById(R.id.download);
        mDownloadButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "downloading", Toast.LENGTH_SHORT).show();
                // Send messages to handler for processing
                for(String song : Playlist.songs){
//                    // 安卓自带的message pool, 可以自动回收重用
//                    Message message = Message.obtain();
//                    message.obj = song;
//                    downloadThread.mDownloadHandler.sendMessage(message);
//                    Intent intent = new Intent(MainActivity.this, DownloadService.class);
                    Intent intent = new Intent(MainActivity.this, DownloadIntentService.class);
                    intent.putExtra(KEY_SONG, song);
                    startService(intent);
                }

            }
        });


    }


}
