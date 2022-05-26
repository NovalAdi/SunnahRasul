package com.vall.sunnahrasul.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vall.sunnahrasul.adapter.ItemAdapter
import com.vall.sunnahrasul.adapter.ItemPuasaSholatAdapter
import com.vall.sunnahrasul.databinding.FragmentPuasaBinding
import com.vall.sunnahrasul.model.DataItem
import com.vall.sunnahrasul.network.RetrofitInterface
import com.vall.sunnahrasul.network.RetrofitService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class PuasaFragment : Fragment() {

    private lateinit var binding: FragmentPuasaBinding
    private lateinit var adapters: ItemPuasaSholatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPuasaBinding.inflate(inflater,container,false)

        adapters = ItemPuasaSholatAdapter()
        binding.rvPuasa.apply {
            adapter = adapters
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val call = RetrofitService.getServiceKategori().getDataPuasa()

        call.enqueue(object : Callback<List<DataItem>> {
            override fun onResponse(
                call: Call<List<DataItem>>,
                response: Response<List<DataItem>>
            ) {
                val list = response.body()!!
                list.let { it.let { it1 -> adapters.addDataItem(it1) } }
            }

            override fun onFailure(call: Call<List<DataItem>>, t: Throwable) {
                Timber.e(t.localizedMessage)
            }
        })
    }
}