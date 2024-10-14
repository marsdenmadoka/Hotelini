package com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto

data class HotelDetailsResponses(
    val data: com.madoka.hotelini.hoteldetail.data.network.hoteldetailsdto.Data,
    val message: String,
    val status: Boolean,
    val timestamp: Long
)



/*val client = OkHttpClient()

val request = Request.Builder()
	.url("https://tripadvisor16.p.rapidapi.com/api/v1/hotels/getHotelDetails?id=23462501&checkIn=2024-10-08&checkOut=2024-10-09&currency=USD")
	.get()
	.addHeader("x-rapidapi-key", "38d12867b2mshcd1cbd3df56a9ccp14ca7ajsn2c5bbd01c0e6")
	.addHeader("x-rapidapi-host", "tripadvisor16.p.rapidapi.com")
	.build()

val response = client.newCall(request).execute() write this as a retrofit function*/


/*
{
    "status": true,
    "message": "Success",
    "timestamp": 1661619809941,
    "data": {
    "photos": [
    {
        "maxHeight": 1733,
        "maxWidth": 2600,
        "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/e5/ee/a4/superior-luxury-room--v15259560.jpg?w={width}&h={height}&s=1"
    },
    {
        "maxHeight": 886,
        "maxWidth": 1737,
        "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/4c/29/80/bedroom.jpg?w={width}&h={height}&s=1"
    },
    {
        "maxHeight": 1329,
        "maxWidth": 886,
        "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/4c/29/7e/lobby.jpg?w={width}&h={height}&s=1"
    },
    {
        "maxHeight": 886,
        "maxWidth": 1297,
        "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/4c/29/83/bathroom.jpg?w={width}&h={height}&s=1"
    },
    {
        "maxHeight": 1440,
        "maxWidth": 960,
        "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/6a/33/4f/bathroom.jpg?w={width}&h={height}&s=1"
    },
    {
        "maxHeight": 1440,
        "maxWidth": 960,
        "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/6a/33/53/abode-bombay.jpg?w={width}&h={height}&s=1"
    },
    {
        "maxHeight": 1388,
        "maxWidth": 960,
        "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/6a/33/52/abode-bombay.jpg?w={width}&h={height}&s=1"
    },
    {
        "maxHeight": 960,
        "maxWidth": 1440,
        "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/6a/33/50/luxury-room.jpg?w={width}&h={height}&s=1"
    },
    {
        "maxHeight": 960,
        "maxWidth": 1440,
        "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/6a/33/54/basic-room.jpg?w={width}&h={height}&s=1"
    },
    {
        "maxHeight": 886,
        "maxWidth": 1387,
        "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/4c/29/87/cafe.jpg?w={width}&h={height}&s=1"
    }
    ],
    "title": "Abode Bombay",
    "rating": 4.5,
    "numberReviews": 1037,
    "rankingDetails": "#1 of 568 hotels in <a>Mumbai</a>",
    "price": {
        "displayPrice": null,
        "strikeThroughPrice": null,
        "status": "IN_PROGRESS",
        "providerName": "Booking.com",
        "freeCancellation": null,
        "pricingPeriod": null
    },
    "about": {
        "title": "Abode Bombay; the city's first authentic boutique hotel. The ultimate anti-chain hotel, Abode is fabulously unconventional in its individuality and style, yet suitably refined when it comes to meeting guests’ expectations. Abode defines a new breed of independent hotel, offering a refreshing contemporary approach to the modern global explorer who seeks an authentic, personal and genuinely engaging experience.",
        "content": [
        {
            "title": "Available languages",
            "content": [
            {
                "title": "",
                "content": "English, Hindi"
            }
            ]
        },
        {
            "title": "Amenities",
            "content": [
            {
                "title": "Free High Speed Internet (WiFi)"
            },
            {
                "title": "Free breakfast"
            },
            {
                "title": "Airport transportation"
            },
            {
                "title": "24-hour security"
            }
            ]
        }
        ],
        "tags": [
        "Quiet",
        "Modern",
        "Centrally Located",
        "Quaint"
        ]
    },
    "reviews": {
        "content": [
        {
            "title": "Abode visit",
            "text": "We had an excellent stay at Abode and would highly recommend it to anyone visiting Mumbai. Abode provided transportation from a woman-run taxi service which picked us up from the airport as well as dropped us off early in the morning (4AM)  at the train station. Not only was this service smooth, but also provides jobs to local women, particularly single mothers or widows, which was a nice touch. <br /><br />Upon arrival, we were offered an in depth explanation of local sites including restaurants, markets, and historical sites. We decided to do the street food tour, led by Vasu, which we would also highly recommend. The tour visited local markets and allowed us to try different types of street food. We were a bit hesitant to try street food without a guide, but Vasu did an excellent job, and we were able to sample some amazing food with the comfort of not worrying about “Delhi Belly” after eating. <br /><br />We also got massages offered by Abode. While the spa set up was somewhat simplistic, the massages were great and were done by blind locals, which provides them with jobs which again was a nice touch.<br /><br />The rooms were very clean and the beds were comfortable. Abode is also zero waste, and offered filtered water in glass bottles which was a welcome change from all of the plastic water bottles we had used previously on our trip. Our departure train was very early in the morning, and Abode provided us with sandwiches for the train and a light breakfast which was great. Overall the stay was amazing and we would definitely stay there again!",
            "bubbleRatingText": "Couples",
            "publishedDate": "Written 11/08/22",
            "userProfile": {
            "deprecatedContributionCount": "5 contributions",
            "avatar": {
            "maxHeight": 205,
            "maxWidth": 205,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-f/01/2e/70/83/avatar004.jpg?w={width}&h={height}&s=1"
        }
        },
            "photos": []
        },
        {
            "title": "perfectly located and intimate",
            "text": "The hotel has a discreet elegance, subtel and chic, refined but never overdoing it. It does feel homely.<br />The staff is helpful and friendly.<br />The location is excellent and manages to be rather quiet too ! Which is a performance in a city such as Mumbai",
            "bubbleRatingText": "",
            "publishedDate": "Written 16/06/22",
            "userProfile": {
            "deprecatedContributionCount": "23 contributions",
            "avatar": {
            "maxHeight": 576,
            "maxWidth": 576,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/07/94/2f/f0/sylvain-g.jpg?w={width}&h={height}&s=1"
        }
        },
            "photos": []
        },
        {
            "title": "A bit over hyped Botique hotel",
            "text": "We took two rooms, one for us as a couple with two small children, one for our parents. One was a Superior Luxury room and one was a Luxury room. The difference between Superior and not-superior was the availability of a bathtub in the middle of the room. <br />Pros:<br />The rooms were charming, nicely decorated with vintage photographs and old style furniture. <br />The staff were courteous, always willing to help.<br />Location, very very close to the Gateway of India.<br />Cons:<br />Ok we should be honest, this hotel would have been great for young travellers who dont have any specific needs. If you go with young children, you need to note - there is no bottled water as they are plastic free, no kettle to boil the water they give, which you generally expect in a hotel at this cost. Once I tried request for warm water from the staff and I got it in a very dirty cup sadly. If it is just us as a couple, we wouldnt have found this a big discomfort. <br />Location - though it was a pro because it is close to attractions, it is a con because it is a very cramped road and the hotel is not visible at all from the road. If you are super comfortable in hailing taxis in Indian cities, you can manage. Sometimes Uber/Ola drops you somewhere on the road. Surprisingly, I couldnt find many convenience stores in the area that is supposedly a very busy market place.<br />They did not come for housekeeping until we called. We did go out during the day, but when we came back the bed was not made and trash was not emptied. As they were a plastic free hotel, there was a beautiful copper water pot used as a trash can. Though it was beautiful, it was super full very fast. But once we called they did come and clean.<br /><br />Overall, we were having issues only because we had old parents and young kids with us in the trip. If you are backpacking travellers, you may love this hotel and have a lot of fun.",
            "bubbleRatingText": "",
            "publishedDate": "Written 09/06/22",
            "userProfile": {
            "deprecatedContributionCount": "27 contributions",
            "avatar": {
            "maxHeight": 1200,
            "maxWidth": 1200,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1a/f6/ea/74/default-avatar-2020-68.jpg?w={width}&h={height}&s=1"
        }
        },
            "photos": []
        }
        ],
        "count": 1037,
        "ratingValue": 4.5,
        "ratingCounts": {
        "average": {
        "percentage": 3,
        "count": "35"
    },
        "excellent": {
        "percentage": 81,
        "count": "835"
    },
        "poor": {
        "percentage": 1,
        "count": "12"
    },
        "terrible": {
        "percentage": 1,
        "count": "7"
    },
        "veryGood": {
        "percentage": 14,
        "count": "148"
    }
    }
    },
    "location": {
        "title": "The area",
        "address": "Lansdowne House M.B. Marg, behind Regal Cinema, Mumbai 400001 India",
        "neighborhood": {
        "name": "Wellington Pier",
        "text": null
    },
        "gettingThere": {
        "title": "How to get there",
        "content": [
        "Mumbai Airport • 19 km"
        ]
    },
        "walkability": null
    },
    "geoPoint": {
        "latitude": 18.92383,
        "longitude": 72.8325
    },
    "restaurantsNearby": {
        "sectionTitle": "Restaurants nearby",
        "content": [
        {
            "title": "Shamiana",
            "bubbleRating": {
            "rating": 4.5,
            "numberReviews": "568"
        },
            "primaryInfo": "₹₹₹₹ • American • Indian • International",
            "distance": "0.2 km",
            "cardPhoto": {
            "maxHeight": 1280,
            "maxWidth": 1596,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0c/f3/dd/5f/homemade-pancakes.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Sea Lounge",
            "bubbleRating": {
            "rating": 4.5,
            "numberReviews": "1,137"
        },
            "primaryInfo": "₹₹₹₹ • Indian • International • Vegetarian Friendly",
            "distance": "0.2 km",
            "cardPhoto": {
            "maxHeight": 1400,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/f2/ac/a3/sea-lounge.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Souk",
            "bubbleRating": {
            "rating": 4.5,
            "numberReviews": "358"
        },
            "primaryInfo": "₹₹₹₹ • Lebanese • Mediterranean • Turkish",
            "distance": "0.3 km",
            "cardPhoto": {
            "maxHeight": 1335,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/f2/87/2a/souk.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Bombay Vintage",
            "bubbleRating": {
            "rating": 4.5,
            "numberReviews": "224"
        },
            "primaryInfo": "₹₹ - ₹₹₹ • Indian • Bar • Vegetarian Friendly",
            "distance": "0.2 km",
            "cardPhoto": {
            "maxHeight": 628,
            "maxWidth": 1200,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/16/c6/19/17/spread.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Golden Dragon",
            "bubbleRating": {
            "rating": 4.5,
            "numberReviews": "439"
        },
            "primaryInfo": "₹₹₹₹ • Chinese • Cantonese • Szechuan",
            "distance": "0.2 km",
            "cardPhoto": {
            "maxHeight": 1500,
            "maxWidth": 1970,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/f2/8c/b7/golden-dragon.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "The Table",
            "bubbleRating": {
            "rating": 4.5,
            "numberReviews": "532"
        },
            "primaryInfo": "₹₹₹₹ • International • European • Vegetarian Friendly",
            "distance": "71 m",
            "cardPhoto": {
            "maxHeight": 361,
            "maxWidth": 550,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-s/02/96/d3/ab/filename-mezzanine-jpg.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Woodside Inn",
            "bubbleRating": {
            "rating": 4,
            "numberReviews": "294"
        },
            "primaryInfo": "₹₹ - ₹₹₹ • Italian • Bar • European",
            "distance": "0.1 km",
            "cardPhoto": {
            "maxHeight": 675,
            "maxWidth": 1200,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/00/c3/7c/interior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Smoke House Deli",
            "bubbleRating": {
            "rating": 4,
            "numberReviews": "276"
        },
            "primaryInfo": "₹₹ - ₹₹₹ • Italian • European • Vegetarian Friendly",
            "distance": "0.2 km",
            "cardPhoto": {
            "maxHeight": 750,
            "maxWidth": 1000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1a/b3/87/de/img-20200125-130008-largejpg.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Cafe Mondegar",
            "bubbleRating": {
            "rating": 4,
            "numberReviews": "1,636"
        },
            "primaryInfo": "₹₹ - ₹₹₹ • Indian • Vegetarian Friendly • Vegan Options",
            "distance": "55 m",
            "cardPhoto": {
            "maxHeight": 452,
            "maxWidth": 678,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/eb/35/34/cafe-mondegar.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Masala Kraft",
            "bubbleRating": {
            "rating": 4,
            "numberReviews": "420"
        },
            "primaryInfo": "₹₹₹₹ • Indian • Asian • Vegetarian Friendly",
            "distance": "0.2 km",
            "cardPhoto": {
            "maxHeight": 1500,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/13/28/48/c8/lovely-classy-interiors.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    "attractionsNearby": {
        "sectionTitle": "Attractions nearby",
        "content": [
        {
            "title": "Popli Art Gallery",
            "bubbleRating": {
            "rating": 5,
            "numberReviews": "3"
        },
            "primaryInfo": "Art Galleries",
            "distance": "41 m",
            "cardPhoto": {}
        },
        {
            "title": "Gateway of India",
            "bubbleRating": {
            "rating": 4,
            "numberReviews": "12,497"
        },
            "primaryInfo": "Points of Interest & Landmarks • Monuments & Statues",
            "distance": "0.3 km",
            "cardPhoto": {
            "maxHeight": 642,
            "maxWidth": 960,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/16/f3/a1/fb-img-1474806779807.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Cathedral of the Holy Name",
            "bubbleRating": {
            "rating": 4.5,
            "numberReviews": "34"
        },
            "primaryInfo": "Churches & Cathedrals",
            "distance": "0.2 km",
            "cardPhoto": {
            "maxHeight": 3648,
            "maxWidth": 5472,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/21/3d/48/interno.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Bowen Memorial Methodist Church",
            "bubbleRating": {
            "rating": 4.5,
            "numberReviews": "4"
        },
            "primaryInfo": "Historic Sites • Churches & Cathedrals",
            "distance": "0.1 km",
            "cardPhoto": {
            "maxHeight": 2048,
            "maxWidth": 1638,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/42/82/ef/church-view-from-the.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Flora Fountain",
            "bubbleRating": {
            "rating": 4,
            "numberReviews": "217"
        },
            "primaryInfo": "Points of Interest & Landmarks • Fountains",
            "distance": "0.2 km",
            "cardPhoto": {
            "maxHeight": 1500,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/a7/98/8b/flora-fountain.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Lion Gate",
            "bubbleRating": {
            "rating": 3,
            "numberReviews": "27"
        },
            "primaryInfo": "Points of Interest & Landmarks",
            "distance": "0.2 km",
            "cardPhoto": {
            "maxHeight": 1936,
            "maxWidth": 2592,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/07/f1/9b/9f/caption.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "L.B. Shastri Statue- Jai Jawan Jai Kisan",
            "bubbleRating": {
            "rating": 3,
            "numberReviews": "1"
        },
            "primaryInfo": "Monuments & Statues",
            "distance": "0.1 km",
            "cardPhoto": {
            "maxHeight": 1152,
            "maxWidth": 648,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1a/30/0e/f3/statue-of-lal-bahadur.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Statue Of Chhatrapati Shivaji Maharaj",
            "bubbleRating": {
            "rating": 3.5,
            "numberReviews": "11"
        },
            "primaryInfo": "Points of Interest & Landmarks • Monuments & Statues",
            "distance": "0.2 km",
            "cardPhoto": {
            "maxHeight": 2000,
            "maxWidth": 1125,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/3f/41/ff/impressive-statue.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Colaba",
            "bubbleRating": {
            "rating": 4.5,
            "numberReviews": "2,494"
        },
            "primaryInfo": "Neighbourhoods",
            "distance": "0.3 km",
            "cardPhoto": {
            "maxHeight": 1338,
            "maxWidth": 1999,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/07/38/3d/94/colaba.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "title": "Chhatrapati Shivaji Maharaj Vastu Sangrahalaya",
            "bubbleRating": {
            "rating": 4.5,
            "numberReviews": "966"
        },
            "primaryInfo": "History Museums",
            "distance": "0.3 km",
            "cardPhoto": {
            "maxHeight": 1500,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/0c/42/80/museum-visit.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    "qA": {
        "content": [
        {
            "title": "Is this place suitable for a family of 5?",
            "writtenDate": "12 March 2022",
            "memberProfile": {
            "profileImage": {}
        },
            "topAnswer": {
            "text": "Hi...We had booked their superior deluxe room and were a family of 3 but it was just right for us. They might have bigger rooms for a family of 5 but I cannot confirm that. You can email Nelcia at their email id. She is super helpful. Hope this helps.",
            "writtenDate": "12 March 2022",
            "thumbsUpCount": 0,
            "memberProfile": {
            "displayName": "Jyo Dmello",
            "hometown": null,
            "profileImage": {
            "maxHeight": 3024,
            "maxWidth": 3024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/24/7b/28/22/alisong1038.jpg?w={width}&h={height}&s=1"
        },
            "contributionCounts": null,
            "deprecatedContributionCount": "1 contribution"
        }
        }
        },
        {
            "title": "Is it a couple friendly hotel?\n",
            "writtenDate": "6 September 2020",
            "memberProfile": {
            "profileImage": {}
        },
            "topAnswer": {
            "text": "Definitly",
            "writtenDate": "7 September 2020",
            "thumbsUpCount": 0,
            "memberProfile": {
            "displayName": "Darren",
            "hometown": null,
            "profileImage": {
            "maxHeight": 1200,
            "maxWidth": 1200,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1a/f6/f4/5d/default-avatar-2020-32.jpg?w={width}&h={height}&s=1"
        },
            "contributionCounts": null,
            "deprecatedContributionCount": "4 contributions"
        }
        }
        }
        ]
    },
    "amenitiesScreen": [
    {
        "title": "Internet",
        "content": [
        "Free High Speed Internet (WiFi)",
        "Wifi"
        ]
    },
    {
        "title": "Food & drink",
        "content": [
        "Free breakfast",
        "Breakfast buffet",
        "Special diet menus"
        ]
    },
    {
        "title": "Transportation",
        "content": [
        "Airport transportation",
        "Taxi service"
        ]
    },
    {
        "title": "General",
        "content": [
        "24-hour security",
        "Baggage storage",
        "Concierge",
        "Currency exchange",
        "Newspaper",
        "Non-smoking hotel",
        "Shared lounge / TV area"
        ]
    },
    {
        "title": "Reception services",
        "content": [
        "24-hour check-in",
        "24-hour front desk",
        "Private check-in / check-out"
        ]
    },
    {
        "title": "Cleaning services",
        "content": [
        "Dry cleaning",
        "Laundry service",
        "Ironing service"
        ]
    },
    {
        "title": "Room types",
        "content": [
        "Non-smoking rooms"
        ]
    },
    {
        "title": "Room features",
        "content": [
        "Air conditioning",
        "Safe",
        "Bottled water",
        "Wake-up service / alarm clock"
        ]
    },
    {
        "title": "Entertainment",
        "content": [
        "Flatscreen TV"
        ]
    }
    ]
}
} */