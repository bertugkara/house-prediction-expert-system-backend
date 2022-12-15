package com.housepredictionbackend.Query.DTO;

import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QueryRequest {

    @NotNull
    Integer bathroomNumber;
    @NotNull
    Boolean west;
    @NotNull
    Boolean east;
    @NotNull
    Boolean south;
    @NotNull
    Boolean north;

    @NotBlank
    String neighbourhood;
    @NotBlank
    String isFurnished;
    @NotNull
    String floor;
    @NotNull
    Integer meterSquare;
    @NotNull
    Integer totalRoomNumber;
    @NotNull
    Integer age;
    @NotNull
    String district;

    @NotNull
    Integer distanceOfMetro;
    @NotNull
    Integer distanceOfMarket;
    @NotNull
    Boolean inSite;
    @NotNull
    Boolean hasView;
    @NotNull
    Boolean hasGarage;
    @NotNull
    Boolean hasBuiltInKitchen;
    @NotNull
    Boolean hasSteelDoor;
    @NotNull
    Boolean isRenovated;
    @NotNull
    Boolean hasPool;
    @NotNull
    Boolean hasGym;
}
