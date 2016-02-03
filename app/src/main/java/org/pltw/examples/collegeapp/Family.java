package org.pltw.examples.collegeapp;

import android.util.Log;

import java.util.ArrayList;

public class Family {
    private static final String TAG = "Family";
    private ArrayList<FamilyMember> mFamily;
    private static Family sFamily;

    private Family() {
        mFamily = new ArrayList<>();
        mFamily.add(new Guardian("Fetty", "Wap", "Rapper"));
        mFamily.add(new Sibling("Bryson", "Tiller"));
    }

    public static Family get(){
        if (sFamily == null){
            Exception d;
            Log.d(TAG, "Error getting sFamily");
            sFamily = new Family();
            Log.d(TAG, "Create new Family");
        }
        return sFamily;
    }

    public ArrayList<FamilyMember> getFamily() {
        return mFamily;
    }

    /*public void setFamily(ArrayList<FamilyMember> family) {
        mFamily = family;
    }*/

    public void addFamilyMember(FamilyMember f) {
        mFamily.add(f);
    }

    public void deleteFamilyMember(FamilyMember f) {
        mFamily.remove(f);
    }
}
