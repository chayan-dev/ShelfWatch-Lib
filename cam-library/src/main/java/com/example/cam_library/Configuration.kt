package com.example.cam_library

import android.content.Context
import android.content.Intent

public class Configuration {

  public fun openCameraSDk(context: Context) {
    val intent = Intent(context, CameraActivity::class.java)
    if (intent.resolveActivity(context.packageManager) != null) {
      intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
      context.startActivity(intent)
    }
  }

}