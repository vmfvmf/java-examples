package com.vmfvmf.controllerservicestrategy;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
	    componentModel = ComponentModel.SPRING,               // Use Spring for dependency injection (or "default", "jsr330", "cdi")
	    unmappedTargetPolicy = ReportingPolicy.IGNORE,  // Ignore unmapped fields (or use .WARN or .ERROR)
	    implementationName = "<CLASS_NAME>Impl", // Custom naming for generated classes
	    disableSubMappingMethodsGeneration = true,
		injectionStrategy = InjectionStrategy.FIELD,
		implementationPackage = "com.vmfvmf.controllerservicestrategy.mapperimpl" // Package for generated implementations
	)
public interface AppMapperConfig {

}