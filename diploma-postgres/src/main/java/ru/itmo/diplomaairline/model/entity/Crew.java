package ru.itmo.diplomaairline.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.diplomaairline.model.entity.pk.CrewPk;

/**
 * Экипаж судна
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crew")
public class Crew {

    @EmbeddedId
    private CrewPk crewPk;

    @Column(name = "role", nullable = false)
    private String role;
}
