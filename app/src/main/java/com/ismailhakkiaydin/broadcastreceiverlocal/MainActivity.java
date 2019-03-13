package com.ismailhakkiaydin.broadcastreceiverlocal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LocalBroadcastManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = LocalBroadcastManager.getInstance(this);

    }

    public void sendNormalBroadcast(View view) {

        Intent intent = new Intent(this, MyReceiver.class);

        intent.putExtra("a", 15);
        intent.putExtra("b", 20);

        sendBroadcast(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("my.result.receiver");
        manager.registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        manager.unregisterReceiver(receiver);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int toplam = intent.getIntExtra("toplam", 0);
            Toast.makeText(context, "Toplam : " + toplam, Toast.LENGTH_LONG).show();
        }
    };


}
