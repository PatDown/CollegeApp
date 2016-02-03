package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

public class Sibling extends FamilyMember implements ApplicantData {
    public Sibling(){
        super();
        setFirstName(" ");
        setLastName(" ");
        setRelation(SIBLING);
    }

    public Sibling(String firstName, String lastName) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setRelation(SIBLING);
    }

    public String toString(){
        return "Sibling: " + mFirstName + " " + mLastName;
    }

    @Override
    public JSONObject toJSON() throws JSONException {
        super.toJSON();
        return new JSONObject();
    }

    public Sibling(JSONObject json) throws JSONException {
        mFirstName = json.getString(JSON_FIRST_NAME);
        mLastName = json.getString(JSON_LAST_NAME);
    }

}
