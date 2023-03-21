package com.example.cam_library.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.cam_library.databinding.FragmentPreviewBinding
import com.example.cam_library.models.CaptureImageModel
import com.example.cam_library.viewmodels.CameraViewModel
import com.xwray.groupie.GroupieAdapter
import kotlinx.coroutines.launch

class PreviewFragment : Fragment() {

  private var binding: FragmentPreviewBinding? = null
  val viewModel : CameraViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = FragmentPreviewBinding.inflate(inflater, container, false)
    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding?.exitBtn?.setOnClickListener { activity?.onBackPressed() }

    val adapter = GroupieAdapter()
    binding?.previewImgRv?.adapter = adapter

    var imgLiveDataList = listOf<PreviewItem>()

    lifecycleScope.launch {
//      viewModel.imageCapturedList.observe(viewLifecycleOwner, {
//        imgLiveDataList = it.toPreviewItem()
//      })
      imgLiveDataList = viewModel.currentImageList.toPreviewItem()
    }

//    val imgList = listOf(R.drawable.img,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,
//      R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,R.drawable.img_8).toPreviewItem()

//    adapter.addAll(imgList)

    Log.d("previewList_size",imgLiveDataList.size.toString())
    adapter.addAll(imgLiveDataList)
  }

//  private fun List<Int>.toPreviewItem(): List<PreviewItem> {
//    return this.map {
//      PreviewItem(
//        it,
//        onClick = { clickedImg->
//          binding?.previewIv?.setImageResource(clickedImg)
//        }
//      )
//    }
//  }

  private fun ArrayList<CaptureImageModel>.toPreviewItem(): List<PreviewItem> {
    return this.map {
      PreviewItem(
        it.image,
        onClick = { clickedImg->
//          binding?.previewIv?.setImageResource(clickedImg)
          binding?.previewIv?.setImageBitmap(clickedImg)

        }
      )
    }
  }


}