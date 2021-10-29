package fr.estia.net.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import fr.estia.net.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var nbClick = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClickMe.setOnClickListener(this)
        binding.linkCalculActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_click_me -> {
                // Toast.makeText(baseContext, "Tu m'as cliqué", Toast.LENGTH_LONG).show()
                nbClick++
                val newText = getString(R.string.you_click, nbClick)
                binding.btnClickMe.text = newText
                binding.textviewClickMe.text = newText
                if (nbClick == 5) {

                    binding.btnClickMe.isClickable = false
                    binding.btnClickMe.isEnabled = false
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
