package com.thomas.studentportal;

import android.os.Parcel;
import android.os.Parcelable;

public class PortalObject implements Parcelable {

    private String url;
    private String title;



    public PortalObject(String url, String title) {
        this.url = url;
        this.title = title;
    }

    protected PortalObject(Parcel in) {
        url = in.readString();
        title = in.readString();
    }

    public static final Creator<PortalObject> CREATOR = new Creator<PortalObject>() {
        @Override
        public PortalObject createFromParcel(Parcel in) {
            return new PortalObject(in);
        }

        @Override
        public PortalObject[] newArray(int size) {
            return new PortalObject[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.title);
    }
}
