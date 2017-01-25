
package com.ibm.mobileappbuilder.pkg20170123065314.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Sheet1Schema5Item implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("instruments") public String instruments;
    @SerializedName("quantity") public Double quantity;
    @SerializedName("picture") public String picture;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(instruments);
        dest.writeValue(quantity);
        dest.writeString(picture);
    }

    public static final Creator<Sheet1Schema5Item> CREATOR = new Creator<Sheet1Schema5Item>() {
        @Override
        public Sheet1Schema5Item createFromParcel(Parcel in) {
            Sheet1Schema5Item item = new Sheet1Schema5Item();

            item.id = in.readString();
            item.instruments = in.readString();
            item.quantity = (Double) in.readValue(null);
            item.picture = in.readString();
            return item;
        }

        @Override
        public Sheet1Schema5Item[] newArray(int size) {
            return new Sheet1Schema5Item[size];
        }
    };

}

