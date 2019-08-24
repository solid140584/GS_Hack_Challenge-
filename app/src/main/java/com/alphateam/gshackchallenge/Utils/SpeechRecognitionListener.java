package com.alphateam.gshackchallenge.Utils;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.util.Log;

public class SpeechRecognitionListener implements RecognitionListener {

    private static final String TAG = SpeechRecognitionListener.class.getSimpleName();
    private SpListener listener;

    public void setOnClickListener(SpListener listener){
        this.listener = listener;
    }

    public void onReadyForSpeech(Bundle params)	{
        Log.d(TAG, "onReadyForSpeech");
    }
    public void onBeginningOfSpeech(){
        Log.d(TAG, "onBeginningOfSpeech");
    }
    public void onRmsChanged(float rmsdB){
        Log.d(TAG, "onRmsChanged");
    }
    public void onBufferReceived(byte[] buffer)	{
        Log.d(TAG, "onBufferReceived");
    }
    public void onEndOfSpeech()	{
        Log.d(TAG, "onEndofSpeech");
    }
    public void onError(int error)	{
       listener.onError("Error");
    }
    public void onResults(Bundle results) {
       if(results!=null) {
           listener.onResults(results);
           Log.d(TAG, "onResults " + results);
       }
    }
    public void onPartialResults(Bundle partialResults) {
        Log.d(TAG, "onPartialResults");
    }
    public void onEvent(int eventType, Bundle params) {
        Log.d(TAG, "onEvent " + eventType);
    }

    public interface SpListener{
        void onResults(Bundle reaults);
        void onError(String error);
    }
}
