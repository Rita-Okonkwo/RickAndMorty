package com.project.rickandmorty

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.RecoverySystem
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.rickandmorty.databinding.FragmentListBinding
import com.project.rickandmorty.services.CharacterService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var list: CharacterResult


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val binding : FragmentListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        val view = binding.root

        val recyclerView: RecyclerView = binding.listRecycler

        recyclerView.layoutManager = GridLayoutManager(context, 3)
        val characterService = CharacterService.Factory.create()
        val names: Call<CharacterResult> = characterService.getNames()
        names.enqueue(object : Callback<CharacterResult>{
            override fun onFailure(call: Call<CharacterResult>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<CharacterResult>,
                response: Response<CharacterResult>
            ) {
                list = response.body()!!
                recyclerView.adapter = CharacterAdapter(list)


            }



        })
        return view
    }

}
