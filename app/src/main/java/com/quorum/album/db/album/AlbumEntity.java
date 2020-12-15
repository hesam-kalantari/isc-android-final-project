package com.quorum.album.db.album;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.quorum.album.db.BaseEntity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "TLB_ALBUM")
public class AlbumEntity extends BaseEntity
{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;

    @ColumnInfo(name = "EXTERNAL_ID")
    private String externalId;

    @ColumnInfo(name = "NAME")
    private String name;

    @ColumnInfo(name = "ARTIST")
    private String artist;

    @ColumnInfo(name = "PUBLISH_DATE")
    private String publishDate;

    @ColumnInfo(name = "IMAGE_URL")
    private String imageUrl;

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
                .append(this.id)
                .append(this.externalId)
                .append(this.name)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        final AlbumEntity that = (AlbumEntity) obj;

        return new EqualsBuilder()
                .append(this.id, that.id)
                .append(this.externalId, that.externalId)
                .append(this.name, that.name)
                .isEquals();
    }
}
