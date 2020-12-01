package com.github.oxal.Jtwitch.channel;

public class Channel {

    private boolean mature;
    private String status;
    private String broadcaster_language;
    private String broadcaster_software;
    private String display_name;
    private String game;
    private String language;
    private long _id;
    private String name;
    private String created_at;
    private String updated_at;
    private boolean partner;
    private String logo;
    private String video_banner;
    private String profile_banner;
    private String profile_banner_background_color;
    private String url;
    private long views;
    private long followers;
    private String broadcaster_type;
    private String description;
    private boolean private_video;
    private boolean privacy_options_enabled;


    public boolean isMature() {
        return mature;
    }

    public void setMature(boolean mature) {
        this.mature = mature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBroadcaster_language() {
        return broadcaster_language;
    }

    public void setBroadcaster_language(String broadcaster_language) {
        this.broadcaster_language = broadcaster_language;
    }

    public String getBroadcaster_software() {
        return broadcaster_software;
    }

    public void setBroadcaster_software(String broadcaster_software) {
        this.broadcaster_software = broadcaster_software;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isPartner() {
        return partner;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getVideo_banner() {
        return video_banner;
    }

    public void setVideo_banner(String video_banner) {
        this.video_banner = video_banner;
    }

    public String getProfile_banner() {
        return profile_banner;
    }

    public void setProfile_banner(String profile_banner) {
        this.profile_banner = profile_banner;
    }

    public String getProfile_banner_background_color() {
        return profile_banner_background_color;
    }

    public void setProfile_banner_background_color(String profile_banner_background_color) {
        this.profile_banner_background_color = profile_banner_background_color;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public String getBroadcaster_type() {
        return broadcaster_type;
    }

    public void setBroadcaster_type(String broadcaster_type) {
        this.broadcaster_type = broadcaster_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivate_video() {
        return private_video;
    }

    public void setPrivate_video(boolean private_video) {
        this.private_video = private_video;
    }

    public boolean isPrivacy_options_enabled() {
        return privacy_options_enabled;
    }

    public void setPrivacy_options_enabled(boolean privacy_options_enabled) {
        this.privacy_options_enabled = privacy_options_enabled;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "mature=" + mature +
                ", status='" + status + '\'' +
                ", broadcaster_language='" + broadcaster_language + '\'' +
                ", broadcaster_software='" + broadcaster_software + '\'' +
                ", display_name='" + display_name + '\'' +
                ", game='" + game + '\'' +
                ", language='" + language + '\'' +
                ", _id=" + _id +
                ", name='" + name + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", partner=" + partner +
                ", logo='" + logo + '\'' +
                ", video_banner='" + video_banner + '\'' +
                ", profile_banner='" + profile_banner + '\'' +
                ", profile_banner_background_color='" + profile_banner_background_color + '\'' +
                ", url='" + url + '\'' +
                ", views=" + views +
                ", followers=" + followers +
                ", broadcaster_type='" + broadcaster_type + '\'' +
                ", description='" + description + '\'' +
                ", private_video=" + private_video +
                ", privacy_options_enabled=" + privacy_options_enabled +
                '}';
    }
}
