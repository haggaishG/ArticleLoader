package com.exercise.articlesloader.model

class Article(
        /*
    {
		"metaData": {
			"creationTime": "2017-03-14T06:44:19.000Z",
			"updateTime": "2017-06-19T14:29:25.000Z"
		},
		"id": "13618709861800811899",
		"title": "Inspirational Street Art on the Walls of Tel Aviv",
		"imageUrl": "https://cdn.theculturetrip.com/wp-content/uploads/2017/03/omer1.jpg",
		"isSaved": true,
		"isLiked": true,
		"likesCount": 23,
		"category": "Art",
		"author": {
			"id": "3571",
			"authorName": "Ben Jakob",
			"authorAvatar": {
				"imageUrl": "https://0.gravatar.com/avatar/430b63571071ec81d57f3605b59a2508?s=50&d=https://cdn.theculturetrip.com/logo/logo50.png&r=g"
			}
		}
	}
     */
        val metaData: MetaData,
        val id: String,
        val title: String,
        val imageUrl: String,
        val isSaved: Boolean,
        val isLiked: Boolean,
        val likesCount: Int,
        val category: String,
        val author: Author) 