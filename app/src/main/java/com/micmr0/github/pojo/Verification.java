package com.micmr0.github.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Verification implements Parcelable {
    private boolean verified;
    private String reason;
    private String signature;
    private String payload;

    protected Verification(Parcel in) {
        verified = in.readByte() != 0;
        reason = in.readString();
        signature = in.readString();
        payload = in.readString();
    }

    public static final Creator<Verification> CREATOR = new Creator<Verification>() {
        @Override
        public Verification createFromParcel(Parcel in) {
            return new Verification(in);
        }

        @Override
        public Verification[] newArray(int size) {
            return new Verification[size];
        }
    };

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (verified ? 1 : 0));
        dest.writeString(reason);
        dest.writeString(signature);
        dest.writeString(payload);
    }
}
