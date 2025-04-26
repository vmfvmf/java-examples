package com.vmfvmf.entity.mapping;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MapperConfig;

@MapperConfig(
	    componentModel = ComponentModel.SPRING,               // Use Spring for dependency injection (or "default", "jsr330", "cdi")
	    unmappedTargetPolicy = ReportingPolicy.IGNORE,  // Ignore unmapped fields (or use .WARN or .ERROR)
	    implementationName = "<CLASS_NAME>Impl", // Custom naming for generated classes
	    disableSubMappingMethodsGeneration = true,
		injectionStrategy = InjectionStrategy.FIELD,
		implementationPackage = "com.vmfvmf.entity.mapping.mapperimpl" // Package for generated implementations
	)
public interface AppMapperConfig {

}