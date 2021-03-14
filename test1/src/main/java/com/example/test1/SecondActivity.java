package com.example.test1;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class SecondActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    ImageView imageview = (ImageView) findViewById(R.id.image2);
    Glide.with(this)
        .load(
            "https://desk-fd.zol-img.com.cn/t_s1920x1080c5/g6/M00/0F/00/ChMkKWBJem-IWA4yACDNjJqF_T8AALOTgFJKNwAIM2k184.jpg")
        .into(imageview);
  }
}