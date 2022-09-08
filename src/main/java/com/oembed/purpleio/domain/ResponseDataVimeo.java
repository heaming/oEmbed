package com.oembed.purpleio.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResponseDataVimeo extends DefaultResponseData{

    private String accountType;
    private String thumbnailUrlWithPlayButton;
    private String description;
    private String uri;
    private Integer duration;
    private String isPlus;
    private String uploadDate;
    private String video_id;

    public ResponseDataVimeo() {}

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getThumbnailUrlWithPlayButton() {
        return thumbnailUrlWithPlayButton;
    }

    public void setThumbnailUrlWithPlayButton(String thumbnailUrlWithPlayButton) {
        this.thumbnailUrlWithPlayButton = thumbnailUrlWithPlayButton;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getIsPlus() {
        return isPlus;
    }

    public void setIsPlus(String isPlus) {
        this.isPlus = isPlus;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }
}
