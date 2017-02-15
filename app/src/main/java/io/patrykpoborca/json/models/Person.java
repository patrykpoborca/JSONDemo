package io.patrykpoborca.json.models;

import android.support.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

public class Person {

    private final String firstName;
    private final String lastName;
    private final Weight weight;

    public Person(String firstName, String lastName, Weight weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Weight getWeight() {
        return weight;
    }

    @Nullable
    public static Person deserialize(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);

            return new Person(jsonObject.getString("firstName"),
                    jsonObject.isNull("lastName") ? null : jsonObject.getString("lastName"),
                    Weight.deserialize(jsonObject.getJSONObject("weight")));

        } catch (JSONException e) {
            return null;
        }
    }

    public JSONObject serialize() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("firstName", firstName);
            jsonObject.put("lastName", lastName);
            jsonObject.put("weight", weight.serialize());
            return jsonObject;
        }
        catch (Exception e) {
            return jsonObject;
        }
    }
}
