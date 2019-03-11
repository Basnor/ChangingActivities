package com.example.changingactivities;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    public String firstName;
    public String lastName;
    public String surName;

    public Student(){

    }

    protected Student(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        surName = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(surName);
    }
}
