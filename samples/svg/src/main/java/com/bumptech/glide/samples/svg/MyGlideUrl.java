package com.bumptech.glide.samples.svg;

import com.bumptech.glide.load.model.GlideUrl;

public class MyGlideUrl extends GlideUrl {

  String murl;

  public MyGlideUrl(String url) {
    super(url);
    this.murl = url;
  }

  @Override
  public String getCacheKey() {
    return super.getCacheKey();
  }

  private String findTokenParam() {
    String tokenParam = "";
    int tokenKeyIndex =
        murl.contains("?token=") ? murl.indexOf("?token=") : murl.indexOf("&token=");
    if (tokenKeyIndex != -1) {
      int nextAndIndex = murl.indexOf("&", tokenKeyIndex + 1);
      if (nextAndIndex != -1) {
        tokenParam = murl.substring(tokenKeyIndex + 1, nextAndIndex + 1);
      } else {
        tokenParam = murl.substring(tokenKeyIndex);
      }
    }
    return tokenParam;
  }
}
