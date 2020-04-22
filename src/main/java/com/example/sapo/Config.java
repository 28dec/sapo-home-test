package com.example.sapo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="config")
public class Config {
    private int id;
    private int config;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "config")
    public int getConfig() {
        return config;
    }

    public void setConfig(int config) {
        this.config = config;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config1 = (Config) o;
        return id == config1.id &&
                config == config1.config;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, config);
    }
}
