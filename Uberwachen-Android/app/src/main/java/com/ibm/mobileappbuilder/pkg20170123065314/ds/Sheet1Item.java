
package com.ibm.mobileappbuilder.pkg20170123065314.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Sheet1Item implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("name") public String name;
    @SerializedName("catageory") public String catageory;
    @SerializedName("quantityValiable") public Double quantityValiable;
    @SerializedName("code") public String code;
    @SerializedName("dataSheet") public String dataSheet;

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
        dest.writeString(name);
        dest.writeString(catageory);
        dest.writeValue(quantityValiable);
        dest.writeString(code);
        dest.writeString(dataSheet);
    }

    public static final Creator<Sheet1Item> CREATOR = new Creator<Sheet1Item>() {
        @Override
        public Sheet1Item createFromParcel(Parcel in) {
            Sheet1Item item = new Sheet1Item();

            item.id = in.readString();
            item.name = in.readString();
            item.catageory = in.readString();
            item.quantityValiable = (Double) in.readValue(null);
            item.code = in.readString();
            item.dataSheet = in.readString();
            return item;
        }

        @Override
        public Sheet1Item[] newArray(int size) {
            return new Sheet1Item[size];
        }
    };

}

