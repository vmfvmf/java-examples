package com.vmfvmf.entity.mapping;

import java.util.List;

public record PersonDto(Long id, String name, PassportDto passport, List<ContactDto> contacts) {}
