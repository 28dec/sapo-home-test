package com.example.sapo;

import org.springframework.data.repository.CrudRepository;

public interface ConfigRepository extends CrudRepository<Config, Integer> {
    Config findTopByOrderByIdDesc();
}
