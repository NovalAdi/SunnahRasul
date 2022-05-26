package com.vall.sunnahrasul.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vall.sunnahrasul.R
import com.vall.sunnahrasul.adapter.ItemPuasaSholatAdapter
import com.vall.sunnahrasul.databinding.FragmentSholatBinding
import com.vall.sunnahrasul.model.DataItem
import com.vall.sunnahrasul.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SholatFragment : Fragment() {

    private lateinit var binding: FragmentSholatBinding
    private lateinit var adapters: ItemPuasaSholatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSholatBinding.inflate(inflater, container, false)

        adapters = ItemPuasaSholatAdapter()
        binding.rvSholat.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapters
            setHasFixedSize(true)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val call = RetrofitService.getServiceKategori().getDataSholat()

        call.enqueue(object : Callback<List<DataItem>> {
            override fun onResponse(
                call: Call<List<DataItem>>,
                response: Response<List<DataItem>>
            ) {
                val list = response.body()!!
                list.let { it.let { it1 -> adapters.addDataItem(it1) } }
            }

            override fun onFailure(call: Call<List<DataItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}