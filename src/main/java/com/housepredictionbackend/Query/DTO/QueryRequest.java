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
    Integer floor;
    @NotNull
    Integer meterSquare;
    @NotNull
    Integer totalRoomNumber;
    @NotNull
    Integer age;
}
