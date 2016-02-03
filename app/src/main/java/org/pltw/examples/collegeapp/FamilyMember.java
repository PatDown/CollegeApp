package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class FamilyMember implements ApplicantData, Comparable<FamilyMember> {
    protected static final String JSON_FIRST_NAME = "firstName";
    protected static final String JSON_LAST_NAME = "lastName";
    protected String mFirstName;
    protected String mLastName;
    public static final int GUARDIAN = 0;
    public static final int SIBLING = 1;
    private int mRelation;
    protected static final String EXTRA_RELATION = "relation";
    protected static final String EXTRA_INDEX = "index";

    public int getRelation() {
        return mRelation;
    }

    public void setRelation(int relation) {
        mRelation = relation;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_FIRST_NAME, mFirstName);
        json.put(JSON_LAST_NAME, mLastName);
        return json;
    }
    @Override
    public int compareTo(FamilyMember another) {
        if(another instanceof Guardian) {
            return 0;
        }
        else if (another instanceof Sibling){
            return 1;
        }
        else {
            return 2;
        }
    }
}
