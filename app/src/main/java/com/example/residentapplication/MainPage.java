package com.example.residentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import com.google.zxing.WriterException;
import android.view.WindowManager;
import android.view.Display;

import android.graphics.Bitmap;
import android.graphics.Point;

public class MainPage extends AppCompatActivity {

    ImageView qrCodeIV;
    QRGEncoder qrgEncoder;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.MSG);
        TextView textView=findViewById(R.id.textView3);
        textView.setText(""+message);
        String str="123123123123";

        qrCodeIV=findViewById(R.id.imageView);
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);


        Display display = manager.getDefaultDisplay();


        Point point = new Point();
        display.getSize(point);


        int width = point.x;
        int height = point.y;

        // generating dimension from width and height.
        int dimen = width < height ? width : height;
        dimen = dimen * 3 / 4;

        // setting this dimensions inside our qr code
        // encoder to generate our qr code.
        qrgEncoder = new QRGEncoder(str, null, QRGContents.Type.TEXT, dimen);
        try {

            bitmap = qrgEncoder.encodeAsBitmap();
            qrCodeIV.setImageBitmap(bitmap);
        } catch (WriterException e) {

            //Log.e("Tag", e.toString());
        }

    }


}