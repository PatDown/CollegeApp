package org.pltw.examples.collegeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class SiblingFragment extends Fragment {
    private static final String TAG = "SiblingFragment";
    //private static final String FILENAME = "sibling.json";
    //private static final String KEY_FIRST_NAME = "firstname";
    private Sibling mSibling;
    private TextView mFirstName;
    private TextView mLastName;
    //private SiblingJSONStorer mStorer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_sibling, container, false);

        mSibling = new Sibling();

        mFirstName = (TextView)rootView.findViewById(R.id.first_name);
        EditText enterFirstName = (EditText) rootView.findViewById(R.id.enter_first_name);
        mLastName = (TextView)rootView.findViewById(R.id.last_name);
        EditText enterLastName = (EditText) rootView.findViewById(R.id.enter_last_name);

        mFirstName.setText(mSibling.getFirstName());
        mLastName.setText(mSibling.getLastName());

        FirstNameTextChanger firstNameTextChanger = new FirstNameTextChanger();
        LastNameTextChanger lastNameTextChanger = new LastNameTextChanger();

        enterFirstName.addTextChangedListener(firstNameTextChanger);

        enterLastName.addTextChangedListener(lastNameTextChanger);
        Context appContext = this.getActivity();
        Log.d(TAG, "Context: " + appContext);

        //mStorer = new SiblingJSONStorer(mAppContext, FILENAME);
        return rootView;
    }

    private class FirstNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mSibling.setFirstName(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            mFirstName.setText(mSibling.getFirstName());
        }
    }

    private class LastNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mSibling.setLastName(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            mLastName.setText(mSibling.getLastName());
        }
    }
    /*public boolean saveSibling() {
        try {
            mStorer.save(mSibling);
            Log.d(TAG, "sibling saved to file.");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error saving sibling: ", e);
            return false;
        }
    }
    public boolean loadSibling() {
        try {
            mSibling = mStorer.load();
            mFirstName.setText(mSibling.getFirstName());
            mLastName.setText(mSibling.getLastName());
            Log.d(TAG, "Sibling loaded from file.");

            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error loading sibling", e);
            mSibling = new Sibling();
            Log.e(TAG, "Error loading Sibling from: " + FILENAME, e);
            return false;
        }
    }*/
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment started.");
    }

    @Override
    public void onPause() {
        super.onPause();
        //saveSibling();
        Log.d(TAG, "Fragment paused.");
    }

    @Override
    public void onResume() {
        super.onResume();
        //loadSibling();
        Log.d(TAG, "Fragment resumed.");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment stopped.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment destroyed.");
    }
}
