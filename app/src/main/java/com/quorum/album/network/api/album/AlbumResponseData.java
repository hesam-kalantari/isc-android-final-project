package com.quorum.album.network.api.album;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quorum.album.network.BaseResponseData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumResponseData extends BaseResponseData
{

    @JsonProperty(value = "_id")
    private String externalId;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "artist")
    private String artist;

    @JsonProperty(value = "publish_date")
    private String publishDate;

    @JsonProperty(value = "image_url")
    private String imageUrl;
}
