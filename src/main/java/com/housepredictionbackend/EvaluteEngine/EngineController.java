package com.housepredictionbackend.EvaluteEngine;

import com.housepredictionbackend.Query.Entity.Query;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class EngineController {
    private ScriptEngine engine;
    public EngineController(){
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName("graal.js");
    }
    public void putValues(Query query){
        engine.put("bathroomNumber",query.getBathroomNumber());
        engine.put("west",query.getWest());
        engine.put("east",query.getEast());
        engine.put("south",query.getSouth());
        engine.put("north",query.getNorth());
        engine.put("neighbourhood",query.getNeighbourhood());
        engine.put("isFurnished",query.getIsFurnished());
        engine.put("floor",query.getFloor());
        engine.put("meterSquare",query.getMeterSquare());
        engine.put("totalRoomNumber",query.getTotalRoomNumber());
        engine.put("age",query.getAge());
        engine.put("district",query.getDistrict());
        engine.put("distanceOfMetro",query.getDistanceOfMetro());
        engine.put("distanceOfMarket",query.getDistanceOfMarket());
        engine.put("inSite",query.getInSite());
        engine.put("hasView",query.getHasView());
        engine.put("hasGarage",query.getHasGarage());
        engine.put("hasBuiltInKitchen",query.getHasBuiltInKitchen());
        engine.put("hasSteelDoor",query.getHasSteelDoor());
        engine.put("isRenovated",query.getIsRenovated());
        engine.put("hasPool",query.getHasPool());
        engine.put("hasGym",query.getHasGym());

    }

    public ScriptEngine getEngine() {
        return engine;
    }
}

