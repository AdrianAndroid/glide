package com.example.test1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.ViewTarget;

public class MyLayout extends LinearLayout {
  private ViewTarget<MyLayout, DrawableImageViewTarget> viewTarget;

  public MyLayout(Context context) {
    super(context);
  }

  public MyLayout(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public MyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }
}
