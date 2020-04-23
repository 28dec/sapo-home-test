package com.example.sapo.interfaces;

import com.example.sapo.entities.Config;
import org.springframework.data.repository.CrudRepository;

public interface ConfigRepository extends CrudRepository<Config, Integer> {
    Config findTopByOrderByIdDesc();
}
