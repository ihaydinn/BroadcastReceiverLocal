package com.ismailhakkiaydin.broadcastreceiverlocal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int ilkSayi=intent.getIntExtra("a", 0);
        int ikinciSayi=intent.getIntExtra("b", 0);
        int toplamDeger= ilkSayi + ikinciSayi;

        LocalBroadcastManager manager=LocalBroadcastManager.getInstance(context);

        Intent returningIntent=new Intent("my.result.receiver");
        returningIntent.putExtra("toplam", toplamDeger);
        manager.sendBroadcast(returningIntent);

    }
}