package com.padc.firebasemlkit_sample_android.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.core.graphics.scale
import com.bumptech.glide.Glide
import java.io.InputStream

fun Uri.ftoBitmap(context: Context): Bitmap {
    val inputStream: InputStream? = context.contentResolver.openInputStream(this)
    val bitmap = BitmapFactory.decodeStream(inputStream)
    inputStream?.close()
    return bitmap
}

fun Bitmap.scaleToRatio(ratio : Double) : Bitmap{
    return this.scale((this.width * ratio).toInt(), (this.height * ratio).toInt())
}

fun Uri.loadBitMapFromUri(context: Context): Bitmap {
    return Glide.with(context)
        .asBitmap()
        .load(this)
        .submit()
        .get()
}
