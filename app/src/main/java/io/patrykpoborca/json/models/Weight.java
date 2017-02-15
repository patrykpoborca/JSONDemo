package io.patrykpoborca.json.models;

import org.json.JSONObject;

public class Weight {

    private final double value;
    private final String unitType;

    public Weight(double value, String unitType) {
        this.value = value;
        this.unitType = unitType;
    }

    public Double getValue() {
        return value;
    }

    public String getUnitType() {
        return unitType;
    }

    public static Weight deserialize(JSONObject jsonObject) {
        try {
            return new Weight(jsonObject.getDouble("value"), jsonObject.getString("unitType"));
        }
        catch (Exception e){
            return null;
        }
    }

    public JSONObject serialize() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("value", value);
            jsonObject.put("unitType", unitType);
            return jsonObject;
        }
        catch (Exception e) {
            return jsonObject;
        }
    }
}
