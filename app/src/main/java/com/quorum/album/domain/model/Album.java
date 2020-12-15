package com.quorum.album.domain.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Album implements Serializable
{
    private String name;
    private String artist;
    private String publishDate;
    private String imageUrl;
}
