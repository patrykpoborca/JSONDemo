package io.patrykpoborca.json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONObject;

import io.patrykpoborca.json.models.Person;

public class MainActivity extends AppCompatActivity {

    //from server
    private final String json = "{ \"firstName\" : \"John\", \"weight\" : { \"value\" : 75.5, \"unitType\" : \"KG\" } }";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //need to convert the String that is encoded in JSON to something Java can work with
        Person person = Person.deserialize(json);
        JSONObject jsonObject = person.serialize();
        String result = jsonObject.toString();
        Person revert = Person.deserialize(result);
        Log.d("Done", "Done");
    }
}
