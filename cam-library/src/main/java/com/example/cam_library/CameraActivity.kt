package com.example.cam_library

import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.cam_library.databinding.ActivityCameraBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CameraActivity(
//  val context: ReactApplicationContext
  ): AppCompatActivity() {

  private lateinit var viewBinding: ActivityCameraBinding
//  private var imageCapture: ImageCapture? = null
//  private lateinit var cameraExecutor: ExecutorService

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewBinding = ActivityCameraBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)

    supportFragmentManager.findFragmentById(R.id.NavHostFragment) as NavHostFragment



//    val EmitterObj = Emitter(ReactApplicationContext(applicationContext))

//    val viewModel: CameraViewModel by viewModels()
//    var left = ""
//    var right = ""
//    var top = ""

//    lifecycleScope.launch {
//      repeatOnLifecycle(Lifecycle.State.STARTED){
//        viewModel.uiState.collect {
//          if(it.left.isNotBlank()){
//            left = it.left
//          }
//          if(it.right.isNotBlank()){
//            right = it.right
//          }
//          if(it.top.isNotBlank()){
//            top = it.top
//          }
//        }
//      }
//    }

    // Request camera permissions
//    if (allPermissionsGranted()) {
//      startCamera()
//    } else {
//      ActivityCompat.requestPermissions(
//        this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
//      )
//    }

    // Set up the listeners for take photo and video capture buttons
//    viewBinding.imageCaptureButton.setOnClickListener {
////      takePhoto()
//      Log.d("btn", "clicked1")
////      EmitterObj.emitEventAndIncrement()
//      findNavController(R.id.image_capture_button)
//        .navigate(R.id.action_cameraActivity_to_previewFragment)
//      Log.d("btn", "clicked2")
//    }
//
//    cameraExecutor = Executors.newSingleThreadExecutor()
//  }
//
//  private fun takePhoto() {
//    // Get a stable reference of the modifiable image capture use case
//    val imageCapture = imageCapture ?: return
//
//    // Create time stamped name and MediaStore entry.
//    val name = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
//      .format(System.currentTimeMillis())
//    val contentValues = ContentValues().apply {
//      put(MediaStore.MediaColumns.DISPLAY_NAME, name)
//      put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
//      if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
//        put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
//      }
//    }
//
//    // Create output options object which contains file + metadata
//    val outputOptions = ImageCapture.OutputFileOptions
//      .Builder(
//        contentResolver,
//        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//        contentValues
//      )
//      .build()
//
//    // Set up image capture listener, which is triggered after photo has
//    // been taken
//    imageCapture.takePicture(
//      outputOptions,
//      ContextCompat.getMainExecutor(this),
//      object : ImageCapture.OnImageSavedCallback {
//        override fun onError(exc: ImageCaptureException) {
//          Log.e(TAG, "Photo capture failed: ${exc.message}", exc)
//        }
//
//        override fun onImageSaved(output: ImageCapture.OutputFileResults) {
//          val msg = "Photo capture succeeded: ${output.savedUri}"
//          Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
//          Log.d(TAG, msg)
//        }
//      }
//    )
//
//    imageCapture.takePicture(
//      ContextCompat.getMainExecutor(this),
//      object : ImageCapture.OnImageCapturedCallback() {
//
//        override fun onCaptureSuccess(image: ImageProxy) {
//          super.onCaptureSuccess(image)
//          Log.d("format", "${image.format}")
//          viewBinding.capturedImg.setImageBitmap(image.convertImageProxyToBitmap())
//          image.close()
//        }
//
//        override fun onError(exception: ImageCaptureException) {
//          super.onError(exception)
//          Log.e(TAG, "Photo capture failed: ${exception.message}", exception)
//        }
//      }
//    )
//  }
//
//  private fun startCamera() {
//    val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
//
//    cameraProviderFuture.addListener({
//      // Used to bind the lifecycle of cameras to the lifecycle owner
//      val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
//
//      // Preview
//      val preview = Preview.Builder()
//        .build()
//        .also {
//          it.setSurfaceProvider(viewBinding.viewFinder.surfaceProvider)
//        }
//
//      imageCapture = ImageCapture.Builder()
//        .build()
//
//      // Select back camera as a default
//      val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//
//      try {
//        // Unbind use cases before rebinding
//        cameraProvider.unbindAll()
//
//        // Bind use cases to camera
//        cameraProvider.bindToLifecycle(
//          this, cameraSelector, preview, imageCapture
//        )
//
//      } catch (exc: Exception) {
//        Log.e(TAG, "Use case binding failed", exc)
//      }
//
//    }, ContextCompat.getMainExecutor(this))
//  }
//
//  override fun onRequestPermissionsResult(
//    requestCode: Int,
//    permissions: Array<out String>,
//    grantResults: IntArray
//  ) {
//    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//    if (requestCode == REQUEST_CODE_PERMISSIONS) {
//      if (allPermissionsGranted()) {
//        startCamera()
//      } else {
//        Toast.makeText(
//          this,
//          "Permissions not granted by the user.",
//          Toast.LENGTH_SHORT
//        ).show()
//        finish()
//      }
//    }
//  }

//  private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
//    ContextCompat.checkSelfPermission(
//      baseContext, it
//    ) == PackageManager.PERMISSION_GRANTED
//  }

//  override fun onDestroy() {
//    super.onDestroy()
//    cameraExecutor.shutdown()
//  }

//  companion object {
//    private const val TAG = "CameraXApp"
//    private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
//    private const val REQUEST_CODE_PERMISSIONS = 10
//    val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
//  }
//
//  fun ImageProxy.convertImageProxyToBitmap(): Bitmap {
//    val buffer = planes[0].buffer
//    buffer.rewind()
//    val bytes = ByteArray(buffer.capacity())
//    buffer.get(bytes)
//    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
//  }

  }
}