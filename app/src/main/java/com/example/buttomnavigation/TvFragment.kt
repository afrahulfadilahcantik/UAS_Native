package com.example.buttomnavigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_tv.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TvFragment : Fragment(){
    var tv: List<Tv>? = null
    private lateinit var tvAdapter: TvAdapter

    companion object {
        fun newInstance() = TvFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_tv_list.layoutManager = LinearLayoutManager(activity)
        rv_tv_list.setHasFixedSize(true)
        getTvData { tv: List<Tv> ->
            rv_tv_list.adapter = TvAdapter(tv, object : TvAdapter.OnAdapterListener {
                override fun onClick(result: Tv) {
                    val intent = Intent(activity, DetailTvActivity::class.java)
                    intent.putExtra(DetailTvActivity.EXTRA_DATA, result)
                    startActivity(intent)
                }
            })
        }
    }
    private fun setupRecyclerView(){
        tvAdapter = TvAdapter(arrayListOf(), object : TvAdapter.OnAdapterListener {
            override fun onClick(result: Tv) { val intent = Intent(activity, DetailTvActivity::class.java)
                intent.putExtra(DetailTvActivity.EXTRA_DATA, result)
                startActivity(intent)
            }
        })
        rv_tv_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = tvAdapter
        }
    }
    private fun getTvData(callback: (List<Tv>) -> Unit){
        val apiService = TvApiService.getInstance().create(TvApiInterface::class.java)
        apiService.getTvList().enqueue(object : Callback<TvResponse> {
            override fun onFailure(call: Call<TvResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                tv = response.body()!!.tv

                return callback(response.body()!!.tv)

            }
        })
    }
}