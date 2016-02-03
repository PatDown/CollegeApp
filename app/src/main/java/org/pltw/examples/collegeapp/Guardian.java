package org.pltw.examples.collegeapp;

import org.json.JSONException;
import org.json.JSONObject;

public class Guardian extends FamilyMember implements ApplicantData{

    private static final String JSON_OCCUPATION = "occupation";
    private String mOccupation;

    public Guardian(){
        super();
        setFirstName(" ");
        setLastName(" ");
        setOccupation(" ");
        setRelation(GUARDIAN);
    }

    public Guardian(String firstName, String lastName, String occupation) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setOccupation(occupation);
        setRelation(GUARDIAN);
    }

    /*public String getOccupation() {
        return mOccupation;
    }*/

    public void setOccupation(String occupation) {
        mOccupation = occupation;
    }

    public String toString() {
        return "Guardian: " + mFirstName + " " + mLastName + "\nOccupation: " + mOccupation;
    }

    public JSONObject toJSON() throws JSONException {
        super.toJSON();
        JSONObject json = new JSONObject();
        json.put(JSON_OCCUPATION, mOccupation);
        return json;
    }

    public Guardian(JSONObject json) throws JSONException {
        mFirstName = json.getString(JSON_FIRST_NAME);
        mLastName = json.getString(JSON_LAST_NAME);
        mOccupation = json.getString(JSON_OCCUPATION);
    }
}
