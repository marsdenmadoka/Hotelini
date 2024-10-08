package com.madoka.hotelini.hoteldetail.hoteldetailsdto

data class TopAnswer(
    val memberProfile: MemberProfileX,
    val text: String,
    val thumbsUpCount: Int,
    val writtenDate: String
)