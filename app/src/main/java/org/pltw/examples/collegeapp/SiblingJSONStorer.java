package org.pltw.examples.collegeapp;

import android.content.Context;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class SiblingJSONStorer extends JSONStorer {
    private static final String TAG ="SiblingJSONStorer";

    public SiblingJSONStorer(Context c, String f) {
        super(c, f);
    }
    public void save(ApplicantData applicantData) throws JSONException, IOException {
        if (applicantData instanceof Sibling) {
            Sibling sibling = (Sibling) applicantData;
            Writer writer = null;
            try {
                Log.d(TAG, "Guardian in JSON: " + sibling.toJSON().toString() + " saved to: " +
                        mFilename);
                OutputStream out = mContext.openFileOutput(mFilename, Context.MODE_PRIVATE);
                writer = new OutputStreamWriter(out);
                writer.write(sibling.toJSON().toString());
            } finally {
                if (writer != null)
                    writer.close();
            }
        }
    }

    public Sibling load() throws IOException, JSONException {
        BufferedReader reader = null;
        Sibling sibling = null;
        try {
            Log.d(TAG, "Opening an input stream from: " + mFilename + " with Context:" +
                    mContext);
            InputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            sibling = new Sibling(new JSONObject(jsonString.toString()));
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Error loading Sibling from: " + mFilename, e);
            sibling = new Sibling();
        } finally {
            if (reader != null)
                reader.close();
        }
        return sibling;
    }
}
