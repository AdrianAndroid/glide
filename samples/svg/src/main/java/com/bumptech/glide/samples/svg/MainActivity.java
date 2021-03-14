package com.bumptech.glide.samples.svg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import java.io.File;

public class MainActivity extends Activity {


  ImageView image1;
  String url = "https://desk-fd.zol-img.com.cn/t_s1920x1200c5/g5/M00/01/0E/ChMkJlbKwbSIQ7HWAAOU6-MaglcAALGcgI0Vu4AA5UD828.jpg";
  String url2 = "https://desk-fd.zol-img.com.cn/t_s1920x1200c5/g5/M00/01/0E/error.jpg";
  String url3 = "https://desk-fd.zol-img.com.cn/t_s4096x2160c5/g6/M00/0F/00/ChMkKWBJejqIAW7OAAfwdggCTlwAALOSgM1QwoAB_CO308.jpg";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    image1 = findViewById(R.id.image1);

    GlideBuilder builder = new GlideBuilder();
    builder.setDiskCache(
        new DiskLruCacheFactory(getExternalCacheDir().getAbsolutePath(), 1024 * 1024 * 100));
    Glide.init(this, builder);
  }

  public void secondClick(View view) {
    startActivity(new Intent(this, SecondActivity.class));
  }

  public void dispalyOne(View view) {
    image1.setTag(12345);
    RequestManager requestManager = Glide.with(this);
    RequestBuilder<Drawable> requestBuilder = requestManager.load(url3);
    ViewTarget<ImageView, Drawable> into = requestBuilder.into(image1);
    Toast.makeText(this, "into", Toast.LENGTH_SHORT).show();
  }

  public void displayWorldGlide() {
    Glide.with(this).load(BitmapFactory.decodeResource(getResources(), R.raw.world)).into(image1);
  }

  private void test() {
    new Thread(new Runnable() {
      @Override
      public void run() {
        String url = "";
        final Context context = getApplicationContext();
//        Glide.with(context).addDefaultRequestListener(new RequestListener<Object>() {})
        Glide.with(context).downloadOnly().submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
        Glide.with(context).downloadOnly().preload();
        runOnUiThread(new Runnable() {
          @Override
          public void run() {

          }
        });
      }
    }).start();
  }

  public void displyTwo(View view) {

    Glide.with(this)
        .load("https://b.zol-img.com.cn/desk/bizhi/image/10/4096x2160/1615254122924.jpg")
        .into((ImageView) findViewById(R.id.image2));
    Glide.with(this)
        .load(
            "https://desk-fd.zol-img.com.cn/t_s4096x2160c5/g6/M00/0D/03/ChMkKmBG0_qIYZdrACTn-CQMqogAALG_gAyb3EAJOgQ842.jpg")
        .into((ImageView) findViewById(R.id.image3));
    Glide.with(this)
        .load("https://b.zol-img.com.cn/desk/bizhi/image/10/4096x2160/1615254206107.jpg")
        .into((ImageView) findViewById(R.id.image4));
    Glide.with(this)
        .load("https://b.zol-img.com.cn/desk/bizhi/image/10/4096x2160/1615254255231.jpg")
        .into((ImageView) findViewById(R.id.image5));
  }

  public void displyError(View view) {
    Glide.with(this)
        .load(url2)
        .apply(
            RequestOptions
                .centerCropTransform()
                .placeholder(R.mipmap.ic_launcher)
                .error(android.R.drawable.alert_dark_frame)
        )
        .into(image1);
  }

  public void displyPreload(View view) {
    //File file = new File("/sdcard/DCIM/image (4).jpg");
    for (int i = 1; i < 37; i++) {
      File f = new File("/sdcard/DCIM/image (" + i + ").jpg");
      if (f.exists()) {
        //Glide.with(this).load(f).preload();
        Glide.with(this).load(f).into(image1);
        Toast.makeText(this, f.getName(), Toast.LENGTH_SHORT).show();
      }
    }

    for (String str : strs) {
      Glide.with(this).load(str).into(image1);
    }
    //Glide.with(this).downloadOnly().preload();
  }


  final String[] strs = new String[]{
      "https://img-blog.csdnimg.cn/20210129152651279.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/2021012915262291.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210127143241947.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210112111859948.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210112104351323.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210111114924528.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129152717600.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129152735420.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/2021012915281557.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129152842717.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129152917989.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129152947648.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153002966.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153036960.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153053767.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/2021012915312577.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153141960.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153159254.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/2021012915321833.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153235238.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153257709.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/2021012915331559.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153343271.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153359162.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153424581.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153443228.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153459146.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153523844.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/2021012915354035.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153556905.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153609278.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153630113.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153649291.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/2021012915370747.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153722628.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153739223.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153800278.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153812929.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153829369.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153844100.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153921378.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129153935249.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154001634.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154017774.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154035734.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154059821.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154119155.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154156747.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154219691.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154232698.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154253754.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154313175.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154343706.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154403115.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154420798.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154444704.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154519633.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154543526.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154604135.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154629117.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154654480.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154711300.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70",
      "https://img-blog.csdnimg.cn/20210129154750424.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FkcmlhbkFuZHJvaWQ=,size_16,color_FFFFFF,t_70"
  };

  public void displayWorld(View view) {
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.raw.world);
    image1.setImageBitmap(bitmap);
    Toast.makeText(this, "Display Bitmap World!", Toast.LENGTH_SHORT).show();
  }
}