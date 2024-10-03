package com.madoka.hotelini.home.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coil.network.HttpException
import com.madoka.hotelini.common.data.network.HoteliniApi
import com.madoka.hotelini.home.data.network.Restaurantdto.RestaurantDetail
import com.madoka.hotelini.home.data.network.hoteldto.HotelDetails
import timber.log.Timber
import java.io.IOException

class HotelSource(
    private val api: HoteliniApi,
    private val latitude: Double,
    private val longitude: Double
) :
    PagingSource<Int,HotelDetails>() {
    override fun getRefreshKey(state: PagingState<Int, HotelDetails>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,HotelDetails> {
        return try {
            val nextPage = params.key ?: 1
            val hotelsList =
                api.getNearestHotels(
                    pageNumber = nextPage,
                    latitude = latitude,
                   longitude = longitude
                )

            Timber.d("restaurant list: ${hotelsList.data.data}")
            LoadResult.Page(
                data =hotelsList.data.data,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (hotelsList.data.data.isEmpty()) null else  hotelsList.data.currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}

