package ru.itmo.etl.cassandra.load.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import ru.itmo.etl.cassandra.load.model.pk.FLightsHumansCostPK;

import java.time.LocalDateTime;

/**
 * Сущность запроса "Суммарная стоимость полётов, поиск самого дорого полёта"
 *
 * Запрос 2.
 */
@Table(value = "flights_humans_cost")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FLightsHumansCost {

    @PrimaryKey
    private FLightsHumansCostPK fLightsHumansCostPK;

    @Column(value = "date_start")
    private LocalDateTime dateStart;
    @Column(value = "date_finish")
    private LocalDateTime dateFinish;

    @Column(value = "age")
    private Integer humanAge;
    @Column(value = "place_to")
    private String placeTo;
    @Column(value = "place_from")
    private String placeFrom;

}
