package com.nd.mapper;

import com.nd.entity.Client;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface ClientMapper {
    Optional<Client> getByName(@Param("name") String name);
}
