package fr.estia.net.neighbors.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import fr.estia.net.neighbors.NavigationListener
import fr.estia.net.neighbors.R
import fr.estia.net.neighbors.data.NeighborRepository
import fr.estia.net.neighbors.models.Neighbor

class AddNeighbourFragment : Fragment(), TextWatcher, View.OnClickListener {

    private lateinit var formImage: TextInputEditText
    private lateinit var formName: TextInputEditText
    private lateinit var formTelephone: TextInputEditText
    private lateinit var formWebste: TextInputEditText
    private lateinit var formAdresse: TextInputEditText
    private lateinit var formAbout: TextInputEditText
    private lateinit var formButton: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbor, container, false)

        formImage = view.findViewById(R.id.edit_image)
        formName = view.findViewById(R.id.edit_name)
        formTelephone = view.findViewById(R.id.edit_telephone)
        formWebste = view.findViewById(R.id.edit_webste)
        formAdresse = view.findViewById(R.id.edit_adresse)
        formAbout = view.findViewById(R.id.edit_about)
        formButton = view.findViewById(R.id.form_save)

        (activity as? NavigationListener)?.updateTitle(R.string.nouv_voisin)
        formButton.setOnClickListener(this)

        return view
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged(s: Editable?) {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        val idNeighbor = NeighborRepository.getInstance().getNeighbours().size + 1
        val image: String = formImage.text.toString()
        val name: String = formName.text.toString()
        val tel: String = formTelephone.text.toString()
        val web: String = formWebste.text.toString()
        val adresse: String = formAdresse.text.toString()
        val about: String = formAbout.text.toString()

        val neighbor = Neighbor(

            id = idNeighbor.toLong(),
            name = name,
            avatarUrl = image,
            address = adresse,
            phoneNumber = tel,
            aboutMe = about,
            favorite = false,
            webSite = web

        )

        NeighborRepository.getInstance().createNeighbour(neighbor)
    }
}
