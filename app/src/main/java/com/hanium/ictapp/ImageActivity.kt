package com.hanium.ictapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_image.*
import kotlinx.android.synthetic.main.activity_image.btnHome
import kotlinx.android.synthetic.main.activity_image.view.*
import kotlinx.android.synthetic.main.activity_stay.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.lang.StringBuilder
import kotlin.experimental.or

class ImageActivity : AppCompatActivity() {
    val REQ_STORAGE = 101
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        var intentHome = Intent(this, MainActivity::class.java)
        btnHome.setOnClickListener {
            startActivity(intentHome)
        }

        //갤러리 열기
        btnGallary.setOnClickListener {
            fromGallary()
            Toast.makeText(this, "이미지 띄우기 완료", Toast.LENGTH_LONG).show()
        }

        //사진 업로드
        btnUpload.setOnClickListener {
            imageUpload()
            Toast.makeText(this, "이미지 업로드 완료", Toast.LENGTH_LONG).show()
        }

        //사진 다운로드
        btnDownload.setOnClickListener {
            imageDownload()
            Toast.makeText(this, "이미지 다운로드 완료", Toast.LENGTH_LONG).show()
        }
                
    }


    fun fromGallary() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, REQ_STORAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQ_STORAGE -> {
                    data?.data?.let { uri ->
                        imageView.setImageURI(uri)
                    }
                }
            }
        }
    }



    fun imageUpload() {
        var databaseRef: DatabaseReference = FirebaseDatabase.getInstance().reference

        val image: Drawable = imageView.getDrawable()
        val bitmap: Bitmap = (image as BitmapDrawable).getBitmap()

        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        val uploadImage = stream.toByteArray()
        val simage = byteArrayToBinaryString(uploadImage)

        val key: String = databaseRef.child("/images").push().key!!
        val childUpdates: MutableMap<String, Any> = HashMap()
        childUpdates["/images/$key"] = simage.toString()
        databaseRef.updateChildren(childUpdates)
    }

    fun byteArrayToBinaryString(b: ByteArray): StringBuilder {
        var sb: StringBuilder = StringBuilder()

        for (i in 0 until b.size) {
            sb.append(byteToBinaryString(b[i]))
        }
        return sb
    }

    fun byteToBinaryString(n: Byte): String {
        var sb: StringBuilder = StringBuilder("00000000")
        for (bit in 0 until 8) {
            if ((n.toInt().shr(bit) and 1) > 0) {
                sb.setCharAt(7 - bit, '1')
            }
        }
        return sb.toString()
    }



    fun imageDownload() {
        var databaseRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("/images")

        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) { }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot: DataSnapshot in snapshot.getChildren()) {
                    val image: String = dataSnapshot.getValue().toString()

                    val b: ByteArray = binaryStringToByteArray(image)
                    val stream = ByteArrayInputStream(b)
                    val down_image = Drawable.createFromStream(stream, "image")
                    imageView.setImageDrawable(down_image)
                }
            }
        })
    }

    fun binaryStringToByteArray(s: String): ByteArray {
        val count: Int = s.length / 8
        val b = ByteArray(count)

        for (i in 1 until count) {
            val t = s.substring((i-1)*8, i*8)
            b[i-1] = binaryStringToByte(t)
        }
        return b
    }

    fun binaryStringToByte(s: String): Byte {
        var ret: Byte
        var total: Byte = 0

        for (i in 0 until 8) {
            ret = if (s.get(7-i)=='1') (1.shl(i)).toByte() else 0
            total = (ret.or(total))
        }
        return total
    }

}













