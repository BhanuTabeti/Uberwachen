
package com.ibm.mobileappbuilder.pkg20170123065314.ds;
import java.util.Date;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class LabPicsDSSchemaItem implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("title") public String title;
    @SerializedName("createdBy") public String createdBy;
    @SerializedName("modifiedDate") public Date modifiedDate;
    @SerializedName("downloadUrl") public String downloadUrl;

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
        dest.writeString(title);
        dest.writeString(createdBy);
        dest.writeValue(modifiedDate != null ? modifiedDate.getTime() : null);
        dest.writeString(downloadUrl);
    }

    public static final Creator<LabPicsDSSchemaItem> CREATOR = new Creator<LabPicsDSSchemaItem>() {
        @Override
        public LabPicsDSSchemaItem createFromParcel(Parcel in) {
            LabPicsDSSchemaItem item = new LabPicsDSSchemaItem();

            item.id = in.readString();
            item.title = in.readString();
            item.createdBy = in.readString();
            Long modifiedDateAux = (Long) in.readValue(null);
            item.modifiedDate = modifiedDateAux != null ? new Date(modifiedDateAux) : null;
            item.downloadUrl = in.readString();
            return item;
        }

        @Override
        public LabPicsDSSchemaItem[] newArray(int size) {
            return new LabPicsDSSchemaItem[size];
        }
    };

}

