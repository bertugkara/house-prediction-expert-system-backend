package com.housepredictionbackend.AIModel;

import ai.catboost.CatBoostError;
import ai.catboost.CatBoostModel;
import ai.catboost.CatBoostPredictions;
import com.housepredictionbackend.Query.Entity.Query;

import java.util.ArrayList;

public class AIModel {
    private float [] floatFeatures;
    private String [] stringFeatures;

    private CatBoostModel model;
    public AIModel(Query query){

        try {
            model=CatBoostModel.loadModel("src/main/resources/model.cbm");
        } catch (CatBoostError e) {
            throw new RuntimeException(e);
        }

        floatFeatures=new float[7];
        stringFeatures=new String[4];
        setFloatFeatures(query);
        setStringFeatures(query);

    }
    private float toInt(boolean bool ){
        return (bool) ? 1.0f : 0.0f;
    }
    public void setFloatFeatures(Query query) {
        floatFeatures[0]=query.getTotalRoomNumber().floatValue();
        floatFeatures[1]=query.getAge().floatValue();
        floatFeatures[2]=query.getBathroomNumber().floatValue();
        floatFeatures[3]=toInt(query.getNorth());
        floatFeatures[4]=toInt(query.getSouth());
        floatFeatures[5]=toInt(query.getEast());
        floatFeatures[6]=toInt(query.getWest());

    }
    public void setStringFeatures(Query query){

        stringFeatures[0]=query.getNeighbourhood();
        stringFeatures[1]=query.getDistrict();
        stringFeatures[2]=query.getFloor();
        stringFeatures[3]=query.getIsFurnished();
    }
    public double getPrediction(){
        double result=0.0;
        try {
            CatBoostPredictions prediction = model.predict(floatFeatures,stringFeatures);
            result=prediction.get(0,0);

        } catch (CatBoostError e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
