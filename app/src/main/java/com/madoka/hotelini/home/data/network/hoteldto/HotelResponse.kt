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

/*{"status":true,"message":"Success","timestamp":1728577833566,"data":
    {
        "sortDisclaimer":"Properties nearby sorted by <span class=\"underline\">distance to me</span>", "textGroupStandard":{ "title":"No other places to stay nearby have availability from our partners.", "message":"We found these other options sorted by distance to you" }, "data":[{
        "id":"754603", "title":"1. Taita Hills Safari Resort & Spa", "primaryInfo":"Free breakfast available", "secondaryInfo":"Mlegwa, Kenya", "badge":{ "size":"SMALL", "type":"TRAVELLER_CHOICE", "year":"2024" }, "bubbleRating":{ "count":"520", "rating":4.5 }, "isSponsored":false, "accentedLabel":"25% LESS THAN USUAL", "provider":"Vio.com", "priceForDisplay":"$163", "strikethroughPrice":"$180", "priceDetails":null, "priceSummary":"View all 7 deals from $163", "cardPhotos":[{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":1181, "maxWidth":2099, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/2d/6f/93/ab/heated-infinity-swimming.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":719, "maxWidth":1280, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/19/5f/f3/27/img-20190830-wa0014-largejpg.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":2576, "maxWidth":4592, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/18/10/46/09/seventh-day-adventist.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":2000, "maxWidth":3008, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/a3/ee/99/wild-animals-are-harmless.jpg?w={width}&h={height}&s=1" } }], "commerceInfo":{
        "externalUrl":"https://www.tripadvisor.in/Commerce?p=Vio&src=258286123&geo=754603&from=HotelDateSearch_Hotels&slot=1&matchID=1&oos=0&cnt=7&silo=47458&bucket=997778&nrank=2&crank=2&clt=M&ttype=MobileCR&tm=308489432&managed=false&capped=false&gosox=s2TKcYtwQzOpWt5uW0nTXKhCiWgE0buulPtkgRGLqgdtZx2RzdF_9kyowobOczUTcGGLAwq_DWjFxajgXXY5OP9Vj8m9oMSJWqp6yEHJbHc2GUzwIcILNEIx5a04DrK8YWDGRLiUFU-gONCmXXp79KnAz72A6vOjNKiOkP_EFYznyIAuo1xJcalI_ciSz_I1_vtV8zm3T92R4caFT2MysgkGkcFbqW4KtiZ4bCjOPwD5yImxtb1q6u56YQ0SW0TPU2S4sXjGV7Qsw2T34BQAlwONaMoILEPerzQJbdp3bsY&priceShown=162&pm=AI&hac=AVAILABLE&mbl=BEAT&mbldelta=0&rq=P&rate=126.5700&taxesRate=35.4400&feesRate=0&fees=35.4400&cur=USD&adults=1&child_rm_ages=&inDay=10&outDay=11&rdex=RDEX_6525c7fcff415101882bef11ab6e60b7&rooms=1&inMonth=10&inYear=2024&outMonth=10&outYear=2024&auid=a6da12e0-612c-4c97-8f7f-6af649153598&def_d=true&bld=L_1,D_0,G_1,W_4,U_1,C_241010,T_12&bh=true&cs=1ea4fd0e5c5efda2ddd94c805e6ce6cb5&ik=470b820028234ee08d7ce8ff57708565&aok=60306c98d8af4284b702510192eaf3d9&tp=APS-Hotels", "provider":"Vio.com", "loadingMessage":null, "priceForDisplay":{ "text":"$163", "debugValueKey":null }, "strikethroughPrice":{ "text":"$180" }, "pricingPeriod":null, "details":null, "commerceSummary":{ "text":"View all 7 deals from $163" }, "roomUrgencyMessage":null, "labels":[]
    }
    },{
        "id":"3701508", "title":"2. Lavender Garden Hotel", "primaryInfo":"Free breakfast available", "secondaryInfo":"Wundanyi, Kenya", "badge":{}, "bubbleRating":{ "count":"10", "rating":4 }, "isSponsored":false, "accentedLabel":"15% LESS THAN USUAL", "provider":"Booking.com", "priceForDisplay":"$22", "strikethroughPrice":null, "priceDetails":"Free cancellation • Reserve now, pay at stay", "priceSummary":"View all 2 deals from $22", "cardPhotos":[{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":1500, "maxWidth":2000, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/56/f7/65/wundanyi-town-viewed.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":1500, "maxWidth":2000, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/65/f9/76/wonders-of-taita.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":1500, "maxWidth":2000, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/65/f8/98/lavender-garden-hotel.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":1080, "maxWidth":1920, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/65/f7/6d/lavender-garden-hotel.jpg?w={width}&h={height}&s=1" } }], "commerceInfo":{
        "externalUrl":"https://www.tripadvisor.in/Commerce?p=BookingCom&src=100959872&geo=3701508&from=HotelDateSearch_Hotels&slot=1&matchID=1&oos=0&cnt=2&silo=10476&bucket=902999&nrank=1&crank=1&clt=M&ttype=MobileCR&tm=308489432&managed=false&capped=false&gosox=mZXzNhU9g_4_EmNxG69MxjEoSM-CQyz69g4Ah_XOVmFjDwiyFMDsFzr0e-egIoPxQ9y7M3Ha2RJaoSRSQxnhU5bBEqhTiFJhzH7m_1xKK5cdHXajjSPxXttczoSrCv1KkATyKXNIgeIFGWj0h2MnxTcx8DKz8OJOUFDhtHIWqyFx3BLbWPsEU6TKgDrHu9OBLjfZh83cP6YjqjpT6WLulinzuEh6cBadosasQOLwkK4b-dch_aDrNveqBF2H4jCcixf_sxv8ByCRcF5BytSm1Q&priceShown=22&pm=AI&hac=AVAILABLE&mbl=BEAT&mbldelta=0&rq=P&rate=10.3400&taxesRate=11.6600&feesRate=0&fees=11.6600&cur=USD&adults=1&child_rm_ages=&inDay=10&outDay=11&rdex=RDEX_473a6acd7ccbc6c86e4f4b3010d071f5&rooms=1&inMonth=10&inYear=2024&outMonth=10&outYear=2024&auid=39f4b2d0-2059-4d6f-9e58-7a00eb2dcfee&def_d=true&bld=L_1,D_0,G_1,W_4,U_1,C_241010,T_12&bh=true&cs=1ee0e77595627b9dd3ba13a127a464bd2&ik=470b820028234ee08d7ce8ff57708565&aok=8bde3f2cb37648f499377b4a0986c05f&tp=APS-Hotels", "provider":"Booking.com", "loadingMessage":null, "priceForDisplay":{ "text":"$22", "debugValueKey":null }, "strikethroughPrice":null, "pricingPeriod":null, "details":{ "text":"Free cancellation • Reserve now, pay at stay" }, "commerceSummary":{ "text":"View all 2 deals from $22" }, "roomUrgencyMessage":null, "labels":[]
    }
    },{
        "id":"15183198", "title":"3. Taita Luxury Hotels", "primaryInfo":null, "secondaryInfo":"Wundanyi, Kenya", "badge":{}, "bubbleRating":{ "count":"2", "rating":4.5 }, "isSponsored":false, "accentedLabel":"26% LESS THAN USUAL", "provider":"Booking.com", "priceForDisplay":"$19", "strikethroughPrice":null, "priceDetails":"Free cancellation • Reserve now, pay at stay", "priceSummary":"View all 3 deals from $19", "cardPhotos":[{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":864, "maxWidth":1152, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/9d/75/cc/img-20210206-wa0031-01.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":1152, "maxWidth":864, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/9d/75/cb/img-20210206-wa0018-01.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":864, "maxWidth":1152, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/9d/75/ca/img-20210206-wa0034-01.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":1152, "maxWidth":864, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/9d/75/c9/img-20210206-wa0033-01.jpg?w={width}&h={height}&s=1" } }], "commerceInfo":{
        "externalUrl":"https://www.tripadvisor.in/Commerce?p=BookingCom&src=201700799&geo=15183198&from=HotelDateSearch_Hotels&slot=1&matchID=1&oos=0&cnt=3&silo=10476&bucket=902999&nrank=1&crank=1&clt=M&ttype=MobileCR&tm=308489432&managed=false&capped=false&gosox=mZXzNhU9g_4_EmNxG69MxjEoSM-CQyz69g4Ah_XOVmFjDwiyFMDsFzr0e-egIoPx_ynkxgPhL6A6xi9LyojSTZbBEqhTiFJhzH7m_1xKK5cdHXajjSPxXttczoSrCv1K7dvXFZcK70DzPGR3-oSDEMBHsL_yjQzJbIclb9MSYoQI8mcll2O6fXh8zsMO33-7CQaRwVupbgq2JnhsKM4_APnIibG1vWrq7nphDRJbRM9TZLixeMZXtCzDZPfgFACXA41oyggsQ96vNAlt2nduxg&priceShown=19&pm=AI&hac=AVAILABLE&mbl=BEAT&mbldelta=0&rq=ML&rate=14.7400&taxesRate=3.8300&feesRate=0&fees=3.8300&cur=USD&adults=1&child_rm_ages=&inDay=10&outDay=11&rdex=RDEX_3022999af61524d9cdb0f7bfc274738c&rooms=1&inMonth=10&inYear=2024&outMonth=10&outYear=2024&auid=57d9801c-685a-4d3a-8e14-fbcd565b2cf5&def_d=true&bld=L_1,D_0,G_1,W_4,U_1,C_241010,T_12&bh=true&cs=12b89d1152680e615e93fe42df1d98036&ik=470b820028234ee08d7ce8ff57708565&aok=ada356d3c6c9425597f5f119c31d2a72&tp=APS-Hotels", "provider":"Booking.com", "loadingMessage":null, "priceForDisplay":{ "text":"$19", "debugValueKey":null }, "strikethroughPrice":null, "pricingPeriod":null, "details":{ "text":"Free cancellation • Reserve now, pay at stay" }, "commerceSummary":{ "text":"View all 3 deals from $19" }, "roomUrgencyMessage":null, "labels":[]
    }
    },{
        "id":"7821706", "title":"4. Taita Rocks Hotel", "primaryInfo":null, "secondaryInfo":"Wundanyi, Kenya", "badge":{}, "bubbleRating":{ "count":"17", "rating":4 }, "isSponsored":false, "accentedLabel":false, "provider":null, "priceForDisplay":null, "strikethroughPrice":null, "priceDetails":null, "priceSummary":null, "cardPhotos":[{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":1080, "maxWidth":1920, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/07/aa/c2/79/entrance.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":2432, "maxWidth":3648, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/19/52/76/7d/hotel.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":2432, "maxWidth":3648, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/19/52/76/78/restaurant-and-the-hotel.jpg?w={width}&h={height}&s=1" } },{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":2432, "maxWidth":3648, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/19/52/76/71/hotel.jpg?w={width}&h={height}&s=1" } }], "commerceInfo":{ "provider":null, "loadingMessage":null, "priceForDisplay":null, "strikethroughPrice":null, "pricingPeriod":null, "details":null, "commerceSummary":null, "roomUrgencyMessage":null, "labels":[] }
    },{ "id":"23853037", "title":"5. Lavender Garden Hotel", "primaryInfo":null, "secondaryInfo":"Wundanyi, Kenya", "badge":{}, "bubbleRating":{ "count":null, "rating":null }, "isSponsored":false, "accentedLabel":false, "provider":null, "priceForDisplay":null, "strikethroughPrice":null, "priceDetails":null, "priceSummary":null, "cardPhotos":[], "commerceInfo":{ "provider":null, "loadingMessage":null, "priceForDisplay":null, "strikethroughPrice":null, "pricingPeriod":null, "details":null, "commerceSummary":null, "roomUrgencyMessage":null, "labels":[] } },{ "id":"13072154", "title":"6. Coast Comfort Mwatate", "primaryInfo":null, "secondaryInfo":"Wundanyi, Kenya", "badge":{}, "bubbleRating":{ "count":null, "rating":null }, "isSponsored":false, "accentedLabel":false, "provider":null, "priceForDisplay":null, "strikethroughPrice":null, "priceDetails":null, "priceSummary":null, "cardPhotos":[{ "__typename":"AppPresentation_PhotoItem", "sizes":{ "__typename":"AppPresentation_PhotoItemSizeDynamic", "maxHeight":612, "maxWidth":612, "urlTemplate":"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1b/52/3e/4e/mwatate-singila.jpg?w={width}&h={height}&s=1" } }], "commerceInfo":{ "provider":null, "loadingMessage":null, "priceForDisplay":null, "strikethroughPrice":null, "pricingPeriod":null, "details":null, "commerceSummary":null, "roomUrgencyMessage":null, "labels":[] } },{ "id":"26654308", "title":"7. Mzedu Springs Hotel", "primaryInfo":null, "secondaryInfo":"Mwatate, Kenya", "badge":{}, "bubbleRating":{ "count":null, "rating":null }, "isSponsored":false, "accentedLabel":false, "provider":null, "priceForDisplay":null, "strikethroughPrice":null, "priceDetails":null, "priceSummary":null, "cardPhotos":[], "commerceInfo":{ "provider":null, "loadingMessage":null, "priceForDisplay":null, "strikethroughPrice":null, "pricingPeriod":null, "details":null, "commerceSummary":null, "roomUrgencyMessage":null, "labels":[] } },{ "id":"13530689", "title":"8. Panlis Resort", "primaryInfo":null, "secondaryInfo":"Majego, Kenya", "badge":{}, "bubbleRating":{ "count":null, "rating":null }, "isSponsored":false, "accentedLabel":false, "provider":null, "priceForDisplay":null, "strikethroughPrice":null, "priceDetails":null, "priceSummary":null, "cardPhotos":[], "commerceInfo":{ "provider":null, "loadingMessage":null, "priceForDisplay":null, "strikethroughPrice":null, "pricingPeriod":null, "details":null, "commerceSummary":null, "roomUrgencyMessage":null, "labels":[] } }]
    }
} */







