package com.example.balticseahack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.Blob;


public class ContainerForNew extends LinearLayout {

    public ContainerForNew(String line, Bitmap im, int maxImageSize, boolean color, Context context){
        super(context);
        super.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        super.setOrientation(LinearLayout.VERTICAL);
        if(color) {
            super.setBackgroundColor(Color.WHITE);
        } else {
            super.setBackgroundColor(Color.LTGRAY);
        }

        String[] elem = parseNew(line);

        /*LinearLayout topSpaser = new LinearLayout(context);

        topSpaser.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 50));

        super.addView(topSpaser);*/


         /*byte[] encodeByte = Base64.decode(elem[2], Base64.NO_WRAP);


        Bitmap im = BitmapFactory.decodeByteArray(byteBlob, 0, byteBlob.length);*/

        ImageView image = new ImageView(context);

        image.setImageBitmap(scaleDown(im, maxImageSize));
        image.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));



        super.addView(image);

        RelativeLayout layForHeader = new RelativeLayout(context);


        layForHeader.setGravity(Gravity.CENTER);

        TextView header = new TextView(context);

        header.setText(elem[0]);
        header.setTypeface(header.getTypeface(), Typeface.BOLD);
        header.setScaleX(2f);
        header.setScaleY(2f);


        header.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        layForHeader.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 200));



        layForHeader.addView(header);
        super.addView(layForHeader);

        TextView text = new TextView(context);

        text.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        text.setText("  " +  elem[1]);

        super.addView(text);

        LinearLayout botSpaser = new LinearLayout(context);

        botSpaser.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 100));

        super.addView(botSpaser);

    }

    private Bitmap scaleDown(Bitmap image, float maxImSize){
        float ratio = Math.min(
            (float) maxImSize / image.getWidth(),
            (float) maxImSize / image.getHeight()
        );
        int wibth = Math.round(ratio * image.getWidth());
        int height = Math.round(ratio * image.getHeight());

        Bitmap scaledIm = Bitmap.createScaledBitmap(image, wibth, height, false);
        return scaledIm;
    }

    private String[] parseNew(String line){
        return line.split("\u02ac");
    }


}
