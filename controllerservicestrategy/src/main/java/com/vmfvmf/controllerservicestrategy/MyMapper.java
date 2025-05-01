package com.vmfvmf.controllerservicestrategy;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = AppMapperConfig.class)
public abstract class MyMapper {
	protected abstract MyEntity toEntity(MyEntityDto dto);
	protected abstract MyEntityDto toDto(MyEntity entity);
	
	protected abstract void patch(MyEntityDto dto, @MappingTarget MyEntity entity);
}
