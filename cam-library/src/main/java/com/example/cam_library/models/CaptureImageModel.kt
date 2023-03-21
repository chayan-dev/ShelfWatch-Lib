package com.example.cam_library.models

import android.graphics.Bitmap

data class CaptureImageModel(
  val image: Bitmap,
//  val direction: String? = null,
  val index: Int
)
