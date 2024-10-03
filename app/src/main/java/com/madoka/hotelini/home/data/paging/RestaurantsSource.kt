package com.madoka.hotelini.home.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coil.network.HttpException
import com.madoka.hotelini.common.data.network.HoteliniApi
import com.madoka.hotelini.home.data.network.dto.RestaurantDetail

import okio.IOException
import timber.log.Timber


class RestaurantsSource(
    private val api: HoteliniApi,
//    private val latitude: Double,
//    private val longitude: Double
) :
    PagingSource<Int, RestaurantDetail>() {
    override fun getRefreshKey(state: PagingState<Int, RestaurantDetail>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RestaurantDetail> {
        return try {
            val nextPage = params.key ?: 1
            val restaurantList =
                api.getHotelsInNairobi(
                    page = nextPage,
//                    latitude = latitude,
//                    longitude = longitude
                )

            Timber.d("restaurant list: ${restaurantList.data.data}")
            LoadResult.Page(
                data = restaurantList.data.data,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (restaurantList.data.data.isEmpty()) null else restaurantList.data.currentPage + 1
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}