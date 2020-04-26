package com.amitgupta.video_player_android_library.extension

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import androidx.annotation.UiThread
import java.io.File
import java.io.FileOutputStream
import java.util.*

@UiThread
fun View.show() {
    visibility = View.VISIBLE
}

@UiThread
fun View.hide() {
    visibility = View.GONE
}

@UiThread
fun View.invisible() {
    visibility = View.INVISIBLE
}

@UiThread
fun View.enable(){
    Enum
    this.isEnabled = true
}

@UiThread
fun View.disable(){
    this.isEnabled = false
}

fun View.takeScreenshot(): String {
    val now = Date()
    android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now)

    try {
        // image naming and path  to include sd card  appending name you choose for file
        val mPath = Environment.getExternalStorageDirectory().toString() + File.separator + "screenshot"

        // create bitmap screen capture
        val bitmap = Bitmap.createBitmap(
            this.getWidth(),
            this.getHeight(), Bitmap.Config.ARGB_8888
        )
//        val canvas = Canvas(bitmap)
//        view.draw(canvas)

        val imageFile = File(mPath)

        val outputStream = FileOutputStream(imageFile)
        val quality = 100
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
        outputStream.flush()
        outputStream.close()

        return  mPath
//        openScreenshot(imageFile)
    } catch (e: Throwable) {
        // Several error may come out with file handling or DOM
        e.printStackTrace()
    }
    return ""

}

fun View.openShareImageDialog(filePath: String) {
    val file: File? = context.getFileStreamPath(filePath)

    if (!filePath.equals("")) {
        var values: ContentValues = ContentValues(2)
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        values.put(MediaStore.Images.Media.DATA, file?.getAbsolutePath())
        val contentUriFile: Uri =
            context.getContentResolver()?.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)!!

        val intent: Intent = Intent(Intent.ACTION_SEND)
        intent.setType("image/jpeg")
        intent.putExtra(android.content.Intent.EXTRA_STREAM, contentUriFile)
        context.startActivity(Intent.createChooser(intent, "Share Image"))
    } else {
        //TODO Show error message in toast or dialogs
    }
}

fun View.openScreenshot(imageFile: File) {
//    val intent: Intent = Intent(android.content.Intent.ACTION_SEND)
//    intent.setType("image/jpeg")
//    intent.putExtra(android.content.Intent.EXTRA_STREAM, contentUriFile)
//    startActivity(Intent.createChooser(intent, "Share Image"))

    val intent = Intent()
    intent.setAction(Intent.ACTION_VIEW)
    val uri = Uri.fromFile(imageFile)
    intent.setDataAndType(uri, "image/*")
    context.startActivity(intent)
}