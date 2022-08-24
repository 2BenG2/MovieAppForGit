package com.lectures.movieappex.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

public interface PosterGetter {


    String mainPath = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";



    static void getPosterFromPath(String url, boolean autoPath, ImageView imageView) {
        String resultPath;
        if(autoPath){
            resultPath = mainPath + url;
        }else {
            resultPath = url;
        }
        new DownloadImageTask(imageView)
                .execute(resultPath);

    }



}
class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    final WeakReference<ImageView> bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = new WeakReference<>(bmImage);
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {

        try {
            ImageView temp = bmImage.get();
            temp.setImageBitmap(result);
        }catch (Exception e){
            Log.d("-------ERORR-------",e.getMessage());
        }

    }
}