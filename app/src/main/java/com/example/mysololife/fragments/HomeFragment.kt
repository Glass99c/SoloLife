package com.example.mysololife.fragments

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysololife.R
import com.example.mysololife.contentList.BookmarkRVAdapter
import com.example.mysololife.contentList.ContentModel
import com.example.mysololife.databinding.FragmentHomeBinding
import com.example.mysololife.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    val items = ArrayList<ContentModel>()

    lateinit var rvAdapter: BookmarkRVAdapter
    val bookmarkIdList = mutableListOf<String>()
    val itemKeyList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.tipTap.setOnClickListener {

            it.findNavController().navigate(R.id.action_homeFragment_to_tipFragment)

        }
        binding.bookmarkTap.setOnClickListener {

            it.findNavController().navigate(R.id.action_homeFragment_to_bookmarkFragment)

        }
        binding.talkTap.setOnClickListener {

            it.findNavController().navigate(R.id.action_homeFragment_to_talkFragment)

        }
        binding.storeTap.setOnClickListener {

            it.findNavController().navigate(R.id.action_homeFragment_to_storeFragment)

        }


        rvAdapter = BookmarkRVAdapter(requireContext(), items, itemKeyList, bookmarkIdList)

        val rv : RecyclerView = binding.mainRV
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(requireContext(),2)

        getCategoryData()

        return binding.root
    }
    private fun getCategoryData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataModel in dataSnapshot.children) {

                    val item = dataModel.getValue(ContentModel::class.java)
                    items.add(item!!)
                    itemKeyList.add(dataModel.key.toString())
                }

                rvAdapter.notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ContentsListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.category1.addValueEventListener(postListener)
        FBRef.category2.addValueEventListener(postListener)
        FBRef.category3.addValueEventListener(postListener)
        FBRef.category4.addValueEventListener(postListener)

    }

}