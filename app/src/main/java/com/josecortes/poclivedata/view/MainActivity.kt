package com.josecortes.poclivedata.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.josecortes.androidexperimentslivedata.R
import com.josecortes.poclivedata.view.adapters.FragmentSampleTabAdapter
import com.josecortes.poclivedata.viewmodel.ItemViewModel
import com.josecortes.poclivedata.viewmodel.UserDataViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Class representing a simple user interface containing some data entry section (EditText) and
 * Tabs with Fragments.
 *
 * This PoC shows how to manage the lifecycle of the data using different ViewModels and how to
 * share that information with other system-entities (such as Fragments).
 *
 */
class MainActivity : AppCompatActivity() {

    var userDataViewModel: UserDataViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Retrieve the ViewModels and associate to the Lifecycle of this Activity
        ViewModelProviders.of(this).get(ItemViewModel::class.java).init()
        userDataViewModel = ViewModelProviders.of(this).get(UserDataViewModel::class.java)

        // Something was saved before? Update the ViewModel
        userDataViewModel?.readFrom(savedInstanceState)

        val adapter = FragmentSampleTabAdapter(supportFragmentManager)
        viewpager_main.adapter = adapter
        tabs_main.setupWithViewPager(viewpager_main)

        freeText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                userDataViewModel!!.setData(p0.toString())
            }
        })
    }

    /**
     * Save the UI State contained into the ViewModel. In this case only the UserDataViewModel
     * has been used as it is not necessary to save Repository Data.
     */
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        userDataViewModel?.writeTo(outState)
    }

}
