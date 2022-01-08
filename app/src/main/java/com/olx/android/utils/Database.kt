package com.olx.android.utils

import android.util.Log
import com.google.firebase.database.*
import com.olx.android.models.Ads

class Database {
    private val path = "ads"

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()

    private fun getReference(): DatabaseReference {
        return database.getReference(path)
    }

    fun createAds(ads: Ads) {
        getReference().push().setValue(ads)
    }

    fun readAds(onSuccess: (List<Ads>) -> (Unit), onError: (Any?) -> Unit) {
        getReference().addValueEventListener(object : ValueEventListener{
            override fun onDataChange(data: DataSnapshot) {
                val items = arrayListOf<Ads>()
                for (item: DataSnapshot in data.children) {
                    val adsParser = item.getValue(Ads::class.java)
                    items.add(adsParser!!)
                }
                onSuccess(items)
            }

            override fun onCancelled(p0: DatabaseError) {
                onError(p0)
            }
        })
    }
}