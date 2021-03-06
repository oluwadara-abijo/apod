package com.dara.apod.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dara.apod.R
import com.dara.apod.model.Picture
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.modal_picture_details.*
import kotlinx.android.synthetic.main.modal_picture_details.view.*

class PictureDetailsModal(val picture: Picture) : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = View.inflate(requireContext(), R.layout.modal_picture_details, root_view)
        view.tv_title.text = picture.title
        view.tv_date.text = picture.date
        view.tv_copyright.text = picture.copyright
        view.tv_explanation.text = picture.explanation
        if (picture.copyright.isNullOrEmpty()) {
            view.tv_copyright.visibility = View.INVISIBLE
            view.img_copyright.visibility = View.INVISIBLE
        }
        return view
    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

}