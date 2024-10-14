package com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto

data class TopAnswer(
    val memberProfile: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.MemberProfileX,
    val text: String,
    val thumbsUpCount: Int,
    val writtenDate: String
)