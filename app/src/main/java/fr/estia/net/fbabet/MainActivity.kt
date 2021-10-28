package fr.estia.net.fbabet

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.my_button)
        button.setOnClickListener(this)
        loadImage("https://voyage-onirique.com/wp-content/uploads/2020/03/backiee-138908-landscape-scaled.jpg")
    }

    fun loadImage(url: String) {

        Picasso.get()
            .load(url)
            .resize(500, 500)
            .centerCrop()
            .into(imageView)
    }

    override fun onClick(view: View?) {
        val link =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWiIRe2TfTaXXQoADd_zlTyR0aN5xnN3fJbQ&usqp=CAU.jpg"
        val lstImage: MutableList<String> = mutableListOf<String>(
            "https://voyage-onirique.com/wp-content/uploads/2020/03/backiee-138908-landscape-scaled.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWiIRe2TfTaXXQoADd_zlTyR0aN5xnN3fJbQ&usqp=CAU.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/9/9a/Gull_portrait_ca_usa.jpg",
            "https://www.journaldugeek.com/content/uploads/2021/01/dragon-ball-4995675-1280-640x492.jpg",
        )
        var randomValues = (0..lstImage.lastIndex).random()

        loadImage(lstImage[randomValues])
        Toast.makeText(this, "You click me", Toast.LENGTH_LONG).show()
    }
}
