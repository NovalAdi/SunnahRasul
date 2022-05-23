package com.vall.sunnahrasul.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseSunnah(

	@field:SerializedName("Kategori")
	val kategori: List<KategoriItem?>? = null
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("hadits")
	val hadits: String? = null,

	@field:SerializedName("arti_hadits")
	val artiHadits: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null
) : Parcelable

@Parcelize
data class KategoriItem(

	@field:SerializedName("data")
	val  data: List<DataItem>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null
) : Parcelable
