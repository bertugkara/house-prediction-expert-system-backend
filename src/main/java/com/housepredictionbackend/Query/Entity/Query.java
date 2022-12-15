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
}
