package com.housepredictionbackend.Query.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Query {

    Integer bathroomNumber;
    Boolean west;
    Boolean east;
    Boolean south;
    Boolean north;
    String neighbourhood;
    String isFurnished;
    String floor;
    Short meterSquare;
    Short totalRoomNumber;
    Short age;
    String district;
    Integer distanceOfMetro;
    Integer distanceOfMarket;
    Boolean inSite;
    Boolean hasView;
    Boolean hasGarage;
    Boolean hasBuiltInKitchen;
    Boolean hasSteelDoor;
    Boolean isRenovated;
    Boolean hasPool;
    Boolean hasGym;
    Boolean hasFirePlace             ;
    Boolean hasSecurity              ;
    Boolean hasGreenFeatures         ;
    Boolean hasOutdoorLivingSpace    ;
    Boolean hasBalcony               ;
    Boolean hasWineCellar            ;
    Boolean hasHomeTheatre           ;
    Boolean hasHighCeiling           ;
    Boolean hasElevator              ;
    Boolean hasJacuzzi               ;
    Boolean hasSauna                 ;
    Boolean isNearBeach              ;
    Boolean hasAirConditioning       ;
    Boolean hasSmartHomeAutomation   ;
    Boolean isSoundProof             ;
    Boolean isHeatProof              ;
    Boolean hasCentralAirConditioning;
    Boolean hasInternetInfrastructure;
    Boolean hasDressingRoom          ;
    Boolean hasDoorman               ;
    Boolean hasChildPark             ;
    Boolean isEarthquakeResistant    ;
    Boolean hasWalkingPath           ;
}
