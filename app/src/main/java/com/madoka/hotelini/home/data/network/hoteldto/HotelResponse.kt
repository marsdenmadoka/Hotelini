package com.madoka.hotelini.home.data.network.hoteldto

data class HotelResponse(
    val data: Data,
    val message: String,
    val status: Boolean,
    val timestamp: Long
)



/*
{
    "status": true,
    "message": "Success",
    "timestamp": 1684082740385,
    "data": {
    "sortDisclaimer": "1,000 of 1,000+ places are available, sorted by <span class=\"underline\">distance to me</span>",
    "data": [
    {
        "id": "23462501",
        "title": "1. Margaritaville Resort Times Square",
        "primaryInfo": null,
        "secondaryInfo": "Hudson Yards",
        "badge": {},
        "bubbleRating": {
        "count": "648",
        "rating": 5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Agoda.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2996,
            "maxWidth": 4500,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/38/de/a8/ground-floor-lobby.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1292,
            "maxWidth": 2048,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1d/ce/3c/bb/caption.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1536,
            "maxWidth": 2048,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/21/5a/25/fa/margaritaville-resort.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1536,
            "maxWidth": 2048,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/21/5a/25/fd/margaritaville-resort.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "12301470",
        "title": "2. Moxy NYC Times Square",
        "primaryInfo": null,
        "secondaryInfo": "Tenderloin",
        "badge": {},
        "bubbleRating": {
        "count": "2,877",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2667,
            "maxWidth": 4000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/3f/eb/d7/magic-hour-rooftop-bar.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1458,
            "maxWidth": 1900,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/7c/cf/c4/magic-hour.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 4431,
            "maxWidth": 6720,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/7c/cf/ad/studio-3.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1289,
            "maxWidth": 1900,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/7c/ce/c2/magic-hour-elephant-room.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "23289322",
        "title": "3. Ace Hotel Brooklyn",
        "primaryInfo": null,
        "secondaryInfo": "Boerum Hill",
        "badge": {},
        "bubbleRating": {
        "count": "141",
        "rating": 5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2667,
            "maxWidth": 4000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1d/88/65/31/the-lobby-at-ace-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 7929,
            "maxWidth": 5663,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/b7/1a/39/ace-bklyn-sofa.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 5125,
            "maxWidth": 7688,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/b7/1a/43/ace-suite-ace-brooklyn.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 6695,
            "maxWidth": 4782,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/b7/1a/42/one-bed-suite-ace-brooklyn.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "8035866",
        "title": "4. Hampton Inn Manhattan / Times Square Central",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Hudson Yards",
        "badge": {
        "size": "SMALL",
        "type": "TRAVELLER_CHOICE",
        "year": "2022"
    },
        "bubbleRating": {
        "count": "3,549",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Agoda.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 576,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/7f/cb/1f/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1340,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/13/2c/13/0c/lobby.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/14/9d/b7/times-square-central.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/14/9d/0b/times-square-central.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "93358",
        "title": "5. Pod 51 Hotel",
        "primaryInfo": null,
        "secondaryInfo": "Midtown East",
        "badge": {},
        "bubbleRating": {
        "count": "5,988",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Official Hotel",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 691,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/9d/6c/d4/pod-roof.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1429,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/16/f8/4e/pod-51-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1500,
            "maxWidth": 1875,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/16/f8/2b/pod-51-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1335,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/10/85/b2/3d/pod-51-hotel.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "12514017",
        "title": "6. Pod Brooklyn",
        "primaryInfo": null,
        "secondaryInfo": "Williamsburg",
        "badge": {},
        "bubbleRating": {
        "count": "460",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Official Hotel",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/52/c7/4d/pod-brooklyn.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2807,
            "maxWidth": 4988,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/24/0a/5b/17/rooftop-bar.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 3319,
            "maxWidth": 5898,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/24/0a/5b/14/rooftop-bar.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1152,
            "maxWidth": 2048,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/24/0a/5b/12/rooftop-bar.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "6542529",
        "title": "7. Hampton Inn Brooklyn/Downtown",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Downtown Brooklyn",
        "badge": {
        "size": "SMALL",
        "type": "TRAVELLER_CHOICE",
        "year": "2022"
    },
        "bubbleRating": {
        "count": "1,605",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 715,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/79/a3/5c/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 683,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/79/a4/37/business-center.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 682,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/79/a4/34/business-center.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 692,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/79/a4/32/business-center.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "93464",
        "title": "8. Thompson Central Park New York",
        "primaryInfo": null,
        "secondaryInfo": "Midtown",
        "badge": {
        "size": "SMALL",
        "type": "TRAVELLER_CHOICE",
        "year": "2022"
    },
        "bubbleRating": {
        "count": "287",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 658,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/23/e1/50/8f/guest-room.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 858,
            "maxWidth": 1280,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/22/4b/96/1e/thompson-central-park.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 682,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/23/e1/50/d2/room-view.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 761,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/23/e1/50/b3/bathroom.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "112064",
        "title": "9. Warwick New York",
        "primaryInfo": null,
        "secondaryInfo": "Midtown",
        "badge": {},
        "bubbleRating": {
        "count": "5,361",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 683,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1d/a0/45/91/warwick-new-york.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/70/b7/a9/signature-suite-marion.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1500,
            "maxWidth": 1875,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/70/b8/e8/hotel-entrance-on-54th.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1335,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/70/b9/5d/signature-suite-follies.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "4702280",
        "title": "10. Opera House Hotel",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Mott Haven",
        "badge": {},
        "bubbleRating": {
        "count": "774",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1733,
            "maxWidth": 2600,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0b/7f/46/ba/superior-king--v12464873.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2307,
            "maxWidth": 2880,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0a/04/2f/36/hotel-front.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 744,
            "maxWidth": 1113,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/5c/61/71/king-room.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 654,
            "maxWidth": 960,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/5c/61/16/exterior-shot.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "11726197",
        "title": "11. Hotel RL Brooklyn",
        "primaryInfo": null,
        "secondaryInfo": "Bedford-Stuyvesant",
        "badge": {
        "size": "SMALL",
        "type": "TRAVELLER_CHOICE",
        "year": "2022"
    },
        "bubbleRating": {
        "count": "387",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/4c/73/7b/guest-room.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/4c/73/9d/guest-room.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/4c/73/98/guest-room.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/4c/73/96/guest-room.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "10134568",
        "title": "12. EVEN Hotel Brooklyn, an IHG Hotel",
        "primaryInfo": null,
        "secondaryInfo": "Boerum Hill",
        "badge": {},
        "bubbleRating": {
        "count": "905",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 4000,
            "maxWidth": 6000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/27/78/f1/66/co-working-space-with.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 4000,
            "maxWidth": 4640,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/97/1b/80/even-hotel-brooklyn-an.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 4000,
            "maxWidth": 4640,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/b0/0e/f1/enjoy-the-evening-at.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 4000,
            "maxWidth": 6000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/5a/85/db/indulge-yourself-in-our.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "7792565",
        "title": "13. Boro Hotel",
        "primaryInfo": null,
        "secondaryInfo": "Long Island City, United States",
        "badge": {
        "size": "SMALL",
        "type": "TRAVELLER_CHOICE",
        "year": "2022"
    },
        "bubbleRating": {
        "count": "1,154",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 681,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/95/3a/24/guest-room.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1500,
            "maxWidth": 1842,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/93/46/86/boro-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1500,
            "maxWidth": 1844,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/93/45/c0/boro-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/08/2f/5d/3a/boro-hotel.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "23432053",
        "title": "14. Wingate By Wyndham Bronx Haven Park",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Mott Haven",
        "badge": {},
        "bubbleRating": {
        "count": "106",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 682,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/11/9e/11/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2048,
            "maxWidth": 1542,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/ff/49/ef/wingate-by-wyndham-bronx.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1365,
            "maxWidth": 2048,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/ff/49/ed/wingate-by-wyndham-bronx.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1365,
            "maxWidth": 2048,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/ff/49/ea/wingate-by-wyndham-bronx.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "10127191",
        "title": "15. LIC Hotel",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Long Island City, United States",
        "badge": {},
        "bubbleRating": {
        "count": "647",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1536,
            "maxWidth": 2048,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/1c/5f/43/photo3jpg.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1000,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/e4/a1/2d/view-from-rooftop.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/e4/a1/1a/fitness-center.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1500,
            "maxWidth": 1860,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/e4/a1/33/lic-hotel.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "12596548",
        "title": "16. Hyatt Place Long Island City/New York City",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Long Island City, United States",
        "badge": {
        "size": "SMALL",
        "type": "TRAVELLER_CHOICE",
        "year": "2022"
    },
        "bubbleRating": {
        "count": "489",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 747,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/25/00/2c/02/lobby.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 793,
            "maxWidth": 1080,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/38/50/e1/new-york-city.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 864,
            "maxWidth": 1080,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/38/50/a4/new-york-city.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 720,
            "maxWidth": 1080,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/38/50/a1/new-york-city.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "20173142",
        "title": "17. Canopy by Hilton Jersey City Arts District",
        "primaryInfo": null,
        "secondaryInfo": "Jersey City, United States",
        "badge": {
        "size": "SMALL",
        "type": "TRAVELLER_CHOICE",
        "year": "2022"
    },
        "bubbleRating": {
        "count": "140",
        "rating": 4.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 3280,
            "maxWidth": 4928,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/24/f5/87/canopy-by-hilton-jersey.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 681,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/f6/90/4b/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 3280,
            "maxWidth": 4928,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/24/fc/3b/canopy-by-hilton-jersey.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 3280,
            "maxWidth": 4928,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/24/fc/34/canopy-by-hilton-jersey.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "5523553",
        "title": "18. The Collective Paper Factory",
        "primaryInfo": null,
        "secondaryInfo": "Long Island City, United States",
        "badge": {},
        "bubbleRating": {
        "count": "961",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 280,
            "maxWidth": 426,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/91/07/fd/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 280,
            "maxWidth": 426,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/91/08/0b/queen-private.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 280,
            "maxWidth": 426,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/91/08/0a/king-private-ensuite.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 280,
            "maxWidth": 426,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/91/08/09/guest-room.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "3411847",
        "title": "19. Asiatic Hotel",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Manhattan",
        "badge": {},
        "bubbleRating": {
        "count": "284",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1733,
            "maxWidth": 2600,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0b/40/1a/7b/standard-double-room--v11006434.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1733,
            "maxWidth": 2600,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0b/40/1a/eb/street--v11006460.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1733,
            "maxWidth": 2600,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0b/40/1a/e1/street--v11006416.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1733,
            "maxWidth": 2600,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0b/40/1a/c9/front-desk--v11006463.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "8468727",
        "title": "20. The Brooklyn",
        "primaryInfo": null,
        "secondaryInfo": "Bedford-Stuyvesant",
        "badge": {},
        "bubbleRating": {
        "count": "432",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1000,
            "maxWidth": 1501,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/08/7c/71/18/the-brooklyn-a-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2200,
            "maxWidth": 3303,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/08/7c/57/44/exceptional-style-throughout.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/63/88/3e/the-brooklyn-a-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1000,
            "maxWidth": 1501,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/08/7c/71/13/the-brooklyn-a-hotel.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "98196",
        "title": "21. Hampton Inn Ridgefield Park (Meadowlands Area)",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Ridgefield Park, United States",
        "badge": {},
        "bubbleRating": {
        "count": "779",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Agoda.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 733,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/79/9a/0c/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1433,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/06/2f/4f/e6/hampton-inn-ridgefield.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1433,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/06/2f/50/25/hampton-inn-ridgefield.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1433,
            "maxWidth": 1999,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/06/2f/4f/f8/hampton-inn-ridgefield.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "501354",
        "title": "22. Hilton Garden Inn Queens / JFK Airport",
        "primaryInfo": null,
        "secondaryInfo": "Jamaica, United States",
        "badge": {},
        "bubbleRating": {
        "count": "1,629",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 683,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/64/85/7f/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 680,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/64/85/ac/business-center.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 685,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/64/85/aa/property-amenity.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 671,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/26/64/85/a8/guest-room.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "92603",
        "title": "23. La Quinta Inn & Suites by Wyndham Secaucus Meadowlands",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Secaucus, United States",
        "badge": {},
        "bubbleRating": {
        "count": "1,383",
        "rating": 3.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 682,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/23/e2/52/51/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 4000,
            "maxWidth": 6000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1a/ab/a1/3f/la-quinta-inn-suites.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 4000,
            "maxWidth": 6000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1a/ab/a0/63/la-quinta-inn-suites.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 4000,
            "maxWidth": 6000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1a/ab/9e/3f/la-quinta-inn-suites.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "258689",
        "title": "24. Extended Stay America - Secaucus - Meadowlands",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Secaucus, United States",
        "badge": {
        "size": "SMALL",
        "type": "TRAVELLER_CHOICE",
        "year": "2022"
    },
        "bubbleRating": {
        "count": "369",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 682,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/23/e3/2d/1e/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 768,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/23/e3/2d/8c/picnic-area.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 768,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/23/e3/2d/88/on-premise-guest-laundry.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 682,
            "maxWidth": 1023,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/23/e3/2d/84/bathroom.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "294811",
        "title": "25. Best Western Jamaica Inn",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Jamaica, United States",
        "badge": {},
        "bubbleRating": {
        "count": "594",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1024,
            "maxWidth": 768,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/22/4e/36/a9/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 768,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/22/4e/36/ca/guest-bathroom.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 768,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/22/4e/36/c9/king-bathroom.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 768,
            "maxWidth": 1024,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/22/4e/36/c8/king-bedroom.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "5544308",
        "title": "26. The Parc Hotel",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Flushing, United States",
        "badge": {},
        "bubbleRating": {
        "count": "339",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1023,
            "maxWidth": 682,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/24/ff/4b/cb/theparchotelexterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1332,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/05/97/c4/97/the-parc-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1733,
            "maxWidth": 2601,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0b/0f/43/ec/welcome-to-the-parc-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/64/f1/a5/the-parc-hotel.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "13140760",
        "title": "27. Feather Factory Hotel",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Long Island City, United States",
        "badge": {},
        "bubbleRating": {
        "count": "95",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2048,
            "maxWidth": 1536,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/19/14/c6/5f/photo3jpg.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 720,
            "maxWidth": 960,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/e1/3c/37/feather-factory-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 750,
            "maxWidth": 1333,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/e4/68/a4/img-20181229-175856-largejpg.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 720,
            "maxWidth": 960,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/e1/3c/53/feather-factory-hotel.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "92593",
        "title": "28. Courtyard Secaucus Meadowlands",
        "primaryInfo": null,
        "secondaryInfo": "Secaucus, United States",
        "badge": {},
        "bubbleRating": {
        "count": "310",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2667,
            "maxWidth": 4000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/29/0f/4e/59/exterior.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2667,
            "maxWidth": 4000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/29/0f/4e/75/meadowlands-meeting-room.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2667,
            "maxWidth": 4000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/29/0f/4e/74/meadowlands-theater-setup.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2667,
            "maxWidth": 4000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/29/0f/4e/73/meadowlands-rounds-setup.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "12563488",
        "title": "29. John Hotel",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Flushing, United States",
        "badge": {},
        "bubbleRating": {
        "count": "40",
        "rating": 3.5
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/af/e0/18/handicap-access.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 4015,
            "maxWidth": 2832,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/9e/be/16/getlstd-property-photo.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1500,
            "maxWidth": 1002,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/af/dc/e8/john-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1333,
            "maxWidth": 2000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/f5/a7/16/our-single-queen-room.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    },
    {
        "id": "21511699",
        "title": "30. SpringHill Suites East Rutherford Meadowlands/Carlstadt",
        "primaryInfo": "Free breakfast included",
        "secondaryInfo": "Carlstadt, United States",
        "badge": {},
        "bubbleRating": {
        "count": "27",
        "rating": 4
    },
        "isSponsored": false,
        "accentedLabel": false,
        "provider": "Booking.com",
        "priceForDisplay": null,
        "strikethroughPrice": null,
        "priceDetails": null,
        "priceSummary": null,
        "cardPhotos": [
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2667,
            "maxWidth": 4000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/b7/d7/28/king-suite-city-view.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 2667,
            "maxWidth": 4000,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/27/3d/29/9d/view-from-hotel.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1732,
            "maxWidth": 2309,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/67/81/8b/lobby.jpg?w={width}&h={height}&s=1"
        }
        },
        {
            "__typename": "AppPresentation_PhotoItem",
            "sizes": {
            "__typename": "AppPresentation_PhotoItemSizeDynamic",
            "maxHeight": 1732,
            "maxWidth": 2309,
            "urlTemplate": "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/67/81/8a/lobby-communal-seating.jpg?w={width}&h={height}&s=1"
        }
        }
        ]
    }
    ]
}
} */