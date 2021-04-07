package com.exercise.articlesloader.model;

public class Author {
    //        {
    //            "id": "3571",
    //                "authorName": "Ben Jakob",
    //                "authorAvatar": {
    //            "imageUrl": "https://0.gravatar.com/avatar/430b63571071ec81d57f3605b59a2508?s=50&d=https://cdn.theculturetrip.com/logo/logo50.png&r=g"
    //        }

    private String id;
    private String authorName;
    private Avatar authorAvatar ;

    public Author(String id, String authorName, Avatar authorAvatar) {
        this.id = id;
        this.authorName = authorName;
        this.authorAvatar = authorAvatar;
    }

    public String getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Avatar getAuthorAvatar() {
        return authorAvatar;
    }
}