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
        engine.put("hasFirePlace",query.getHasFirePlace());
        engine.put("hasSecurity",query.getHasSecurity());
        engine.put("hasGreenFeatures",query.getHasGreenFeatures());
        engine.put("hasOutdoorLivingSpace",query.getHasOutdoorLivingSpace());
        engine.put("hasBalcony",query.getHasBalcony());
        engine.put("hasWineCellar",query.getHasWineCellar());
        engine.put("hasHomeTheatre",query.getHasHomeTheatre());
        engine.put("hasHighCeiling",query.getHasHighCeiling());
        engine.put("hasElevator",query.getHasElevator());
        engine.put("hasJacuzzi",query.getHasJacuzzi());
        engine.put("hasSauna",query.getHasSauna());
        engine.put("isNearBeach",query.getIsNearBeach());
        engine.put("hasAirConditioning",query.getHasAirConditioning());
        engine.put("hasSmartHomeAutomation",query.getHasSmartHomeAutomation());
        engine.put("isSoundProof",query.getIsSoundProof());
        engine.put("isHeatProof",query.getIsHeatProof());
        engine.put("hasCentralAirConditioning",query.getHasCentralAirConditioning());
        engine.put("hasInternetInfrastructure",query.getHasInternetInfrastructure());
        engine.put("hasDressingRoom",query.getHasDressingRoom());
        engine.put("hasDoorman",query.getHasDoorman());
        engine.put("hasChildPark",query.getHasChildPark());
        engine.put("isEarthquakeResistant",query.getIsEarthquakeResistant());
        engine.put("hasWalkingPath",query.getHasWalkingPath());
    }

    public ScriptEngine getEngine() {
        return engine;
    }
}

