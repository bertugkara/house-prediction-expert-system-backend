package com.housepredictionbackend.Query.Mapper;

import com.housepredictionbackend.Query.DTO.QueryRequest;
import com.housepredictionbackend.Query.Entity.Query;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QueryMapper {

    QueryMapper INSTANCE = Mappers.getMapper(QueryMapper.class);

    Query dtoToEntity(QueryRequest queryRequest);
}
