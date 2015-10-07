package com.firebasedb;

import android.app.Application;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by rimith on 07-10-2015.
 */
public class FireBaseTest extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
        Firebase rootRef = new Firebase("https://docs-examples.firebaseio.com/web/data");
        Firebase ref = new Firebase("https://appmantrastest.firebaseio.com");
//To send data to firebase db
        ref.child("message").setValue("Hi this is Somu");


//TO retrive data from firebase db
        ref.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });
    }
}
