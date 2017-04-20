package com.dce.puja.imagedownload;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void downloadImageFromServer(View v){ // here u download image...
        MyImageDown ob = new MyImageDown();
        ob.execute();
    }


    class MyImageDown extends AsyncTask{

        Bitmap image;

        @Override
        protected void onProgressUpdate(Object[] values) { // maain..video...10%..20%..40%...
            super.onProgressUpdate(values);
            //update progress bar...
        }

        @Override
        protected void onPostExecute(Object o) { // it will run in main thread
            super.onPostExecute(o);
            ImageView view = (ImageView) findViewById(R.id.imageView);
            view.setImageBitmap(image); // update screen...

        }

        @Override
        protected void onPreExecute() { // main thread...
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) { // worker thread....

            String address ="http://www.wpclipart.com/weather/sun/sun_hot/bright_sun.png";

            try {
                URL url = new URL(address);
                URLConnection connection = url.openConnection();
                connection.connect();
                InputStream steam = connection.getInputStream();//image u getting from server

                image = BitmapFactory.decodeStream(steam);
                //publishProgress(10);
                //publishProgress(20);


            }catch(Exception e){

                e.printStackTrace();
            }
            return null;
        }
    }

}