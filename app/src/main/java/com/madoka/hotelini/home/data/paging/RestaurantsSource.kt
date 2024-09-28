package com.madoka.hotelini.home.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import coil.network.HttpException
import com.madoka.hotelini.common.data.network.HoteliniApi
import com.madoka.hotelini.home.domain.model.Restaurant
import okio.IOException
import timber.log.Timber


class RestaurantsSource (private val api: HoteliniApi):
        PagingSource<Int,Restaurant>(){
    override fun getRefreshKey(state: PagingState<Int, Restaurant>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Restaurant> {
       return try {
           val nextPage = params.key ?: 1
           val restaurantList = api.getHotelsInNairobi(nextPage)
           Timber.d("restraunts list: ${restaurantList.data}")
           LoadResult.Page(
               data = restaurantList.data,
               prevKey = if(nextPage == 1) null else nextPage -1,
               nextKey = if(restaurantList.data.isEmpty()) null else restaurantList.currentPage + 1
           )

       } catch (exception: IOException){
           return LoadResult.Error(exception)
       } catch (exception:HttpException){
           return LoadResult.Error(exception)
       }
    }

}