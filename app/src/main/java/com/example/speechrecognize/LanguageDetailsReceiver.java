package com.example.speechrecognize;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ikromjonov Ma'rufjon
 * data = 4/24/2020 , time = 16:05
 */

public class LanguageDetailsReceiver extends BroadcastReceiver {
    List<String> mLanguages;
    MainActivity mSSL;

    public LanguageDetailsReceiver(MainActivity ssl) {
        mSSL = ssl;
        mLanguages= new ArrayList<String>();
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle extras = getResultExtras(true);
        mLanguages = extras.getStringArrayList
                (RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES);
        if (mLanguages == null) {
            mSSL.updateResults("No voice data found.");
        } else {
            String s = "\nQo'llab-quvatlanadigan tillar ro'yxati:\n";
            for (int i = 0; i < mLanguages.size(); i++) {
                s += (mLanguages.get(i) + ", ");
            }
            s += "\n Jami " + mLanguages.size()+" ta";
            mSSL.updateResults(s);
        }
    }
}