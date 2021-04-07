package com.exercise.articlesloader.model;

public class Article {

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

    private MetaData metaData ;
    private String id;
    private String title;
    private String imageUrl;
    private boolean isSaved;
    private boolean isLiked;
    private int likesCount;
    private String category;
    private Author author ;

    public Article(
            MetaData metaData ,
            String id,
            String title,
            String imageUrl,
            boolean isSaved,
            boolean isLiked,
            int likesCount,
            String category,
            Author author){
        this.metaData = metaData ;
        this.id= id;
        this.title= title;
        this.imageUrl= imageUrl;
        this.isSaved= isSaved;
        this.isLiked= isLiked;
        this.likesCount= likesCount;
        this.category= category;
        this.author = author;
    }
    public MetaData getMetaData() {
        return metaData;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public String getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
