package fr.estia.net.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {
    private lateinit var calculInput1: EditText
    private lateinit var calculInput2: EditText
    private lateinit var calculButton: Button
    private lateinit var resultatTextview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.compute_activity)
        calculButton = findViewById(R.id.btn_calculer)
        calculInput1 = findViewById(R.id.field_1)
        calculInput2 = findViewById(R.id.field_2)
        resultatTextview = findViewById(R.id.resultat)

        calculInput1.addTextChangedListener(this)
        calculInput2.addTextChangedListener(this)

        calculButton.setOnClickListener(this)



    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        calculButton.isEnabled = calculInput1.text.isNotBlank() && calculInput2.text.isNotBlank()



    }

    override fun onClick(v: View?) {
        var result=0.0
        result = calculInput1.text.toString().toDouble() + calculInput2.text.toString().toDouble()
        resultatTextview.text = result.toString()

    }
}
