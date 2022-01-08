package com.olx.android.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ads(
    var author: String = "",
    var description: String = "",
    var location: String = "",
    var price: String = "",
    var title: String = ""
): Parcelable {
    companion object {
        fun generateDummyAds(): List<Ads> {
            val listOfAds = arrayListOf<Ads>()
            for (i in 1..10) {
                if (i%2==0) {
                    listOfAds.add(
                        Ads(
                            author = "Samsul Arifin",
                            description = "OLX Autos adalah solusi terbaik untuk jual mobil secara instan, aman dan nyaman. Dapatkan harga terbaik sesuai dengan kondisi mobil kamu.",
                            location = "Kembangan, Jakarta Barat",
                            price = "Rp175.000.000",
                            title = "Honda Brio RS 2015",
                        )
                    )
                } else {
                    listOfAds.add(
                        Ads(
                            author = "Hamka Hamzah",
                            description = "Mesin asli bensin\n" +
                                    "4x4 aktif.\n" +
                                    "Surat surat lengkap.\n" +
                                    "Pajak hidup.\n" +
                                    "power steering\n" +
                                    "Sudah pakek pakum rem",
                            location = "Kembangan, Jakarta Barat",
                            price = "Rp75.000.000",
                            title = "Hyundai Atoz 2008",
                        )
                    )
                }
            }

            return listOfAds
        }
    }
}