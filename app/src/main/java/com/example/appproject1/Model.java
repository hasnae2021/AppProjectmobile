package com.example.appproject1;

public class Model {


    String mSushiName;
    String mSushiDetails;
    int mSushiPhoto;

    public Model(String mSushiName,String mSushiDetails,int mSushiPhoto) {

        this.mSushiName = mSushiName;
        this.mSushiDetails = mSushiDetails;
        this.mSushiPhoto = mSushiPhoto;
    }


    public String getmSushiName() {
        return mSushiName;
    }

    public String getmSushiDetails() {
        return mSushiDetails;
    }

    public int getmSushiPhoto() {
        return mSushiPhoto;
    }


}
