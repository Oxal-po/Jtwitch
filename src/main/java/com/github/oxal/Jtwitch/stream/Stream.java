package com.github.oxal.Jtwitch.stream;

import com.github.oxal.Jtwitch.channel.Channel;
import com.github.oxal.Jtwitch.channel.preview.Preview;

import java.util.Arrays;
import java.util.Objects;

public class Stream {
    private long _id;
    private String game;
    private String broadcast_platform;
    private String community_id;
    private String[] community_ids;
    private int viewers;
    private int video_height;
    private int average_fps;
    private int delay;
    private String created_at;
    private boolean is_playlist;
    private String stream_type;
    private Preview preview;
    private Channel channel;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getBroadcast_platform() {
        return broadcast_platform;
    }

    public void setBroadcast_platform(String broadcast_platform) {
        this.broadcast_platform = broadcast_platform;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public String[] getCommunity_ids() {
        return community_ids;
    }

    public void setCommunity_ids(String[] community_ids) {
        this.community_ids = community_ids;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    public int getVideo_height() {
        return video_height;
    }

    public void setVideo_height(int video_height) {
        this.video_height = video_height;
    }

    public int getAverage_fps() {
        return average_fps;
    }

    public void setAverage_fps(int average_fps) {
        this.average_fps = average_fps;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean isIs_playlist() {
        return is_playlist;
    }

    public void setIs_playlist(boolean is_playlist) {
        this.is_playlist = is_playlist;
    }

    public String getStream_type() {
        return stream_type;
    }

    public void setStream_type(String stream_type) {
        this.stream_type = stream_type;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    @Override
    public String toString() {
        return "\nStream{" +
                "_id=" + _id +
                ", game='" + game + '\'' +
                ", broadcast_platform='" + broadcast_platform + '\'' +
                ", community_id='" + community_id + '\'' +
                ", community_ids=" + Arrays.toString(community_ids) +
                ", viewers=" + viewers +
                ", video_height=" + video_height +
                ", average_fps=" + average_fps +
                ", delay=" + delay +
                ", created_at='" + created_at + '\'' +
                ", is_playlist=" + is_playlist +
                ", stream_type='" + stream_type + '\'' +
                ", preview=" + preview +
                ", channel=" + channel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stream stream = (Stream) o;
        return _id == stream._id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }
}
