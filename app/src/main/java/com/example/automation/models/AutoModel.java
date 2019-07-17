package com.example.automation.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AutoModel implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String cardName;

    @SerializedName("image")
    @Expose
    private String imgId;

    public AutoModel() {
        this.id = id;
        this.cardName = cardName;
        this.imgId = imgId;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(cardName);
        if (imgId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(imgId);
        }

    }

    public AutoModel(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        cardName = in.readString();
        if (in.readByte() == 0) {
            imgId = null;
        } else {
            imgId = in.readString();
        }
    }
    public static final Creator<AutoModel> CREATOR = new Creator<AutoModel>() {
        @Override
        public AutoModel createFromParcel(Parcel i) {
            return new AutoModel(i);
        }

        @Override
        public AutoModel[] newArray(int i) {
            return new AutoModel[i];
        }
    };
}
