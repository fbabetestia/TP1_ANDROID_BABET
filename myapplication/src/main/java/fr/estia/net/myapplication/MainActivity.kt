package fr.estia.net.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var clickButton: Button
    private lateinit var textClick: TextView
    private lateinit var linkCalculButton: Button
    private var nbClick = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn_click_me)
        textClick = findViewById(R.id.textview_click_me)
        linkCalculButton = findViewById(R.id.link_calcul_activity)
        clickButton.setOnClickListener(this)
        linkCalculButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_click_me -> {
                // Toast.makeText(baseContext, "Tu m'as cliqué", Toast.LENGTH_LONG).show()
                nbClick++
                val newText = "Cliquez moi $nbClick"
                clickButton.text = newText
                textClick.text = newText
                if (nbClick == 5) {

                    clickButton.isClickable = false
                    clickButton.isEnabled = false
                }
            }
            R.id.link_calcul_activity -> {
                val intent = Intent(baseContext, ComputeActivity::class.java)
                startActivity(intent)
            }
            else -> {
            }
        }
    }
}
