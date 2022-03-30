package com.example.mysololife.fragments

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mysololife.R
import com.example.mysololife.databinding.FragmentStoreBinding
import com.example.mysololife.databinding.FragmentTipBinding


class StoreFragment : Fragment() {

    private lateinit var binding : FragmentStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_store,container,false)
        val webView : WebView = view.findViewById(R.id.storeWebView)
        webView.loadUrl("https://www.inflearn.com/")


        view.findViewById<ImageView>(R.id.homeTap).setOnClickListener {

            it.findNavController().navigate(R.id.action_storeFragment_to_homeFragment)

        }
        view.findViewById<ImageView>(R.id.tipTap).setOnClickListener {

            it.findNavController().navigate(R.id.action_storeFragment_to_tipFragment)

        }
        view.findViewById<ImageView>(R.id.talkTap).setOnClickListener {

            it.findNavController().navigate(R.id.action_storeFragment_to_talkFragment)

        }
        view.findViewById<ImageView>(R.id.bookmarkTap).setOnClickListener {

            it.findNavController().navigate(R.id.action_storeFragment_to_bookmarkFragment)

        }

        return view

    }

}