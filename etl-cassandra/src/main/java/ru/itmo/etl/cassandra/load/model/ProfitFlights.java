package ru.itmo.etl.cassandra.load.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import ru.itmo.etl.cassandra.load.model.pk.ProfitFlightsPK;

import java.time.LocalDateTime;

/**
 * Сущность запроса "Самый дорогой полёт по затратам"
 *
 * Запрос 4.
 */
@Table(value = "profit_flights")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfitFlights {

    @PrimaryKey
    private ProfitFlightsPK profitFlightsPK;

    @Column(value = "date_start")
    private LocalDateTime dateStart;
    @Column(value = "date_finish")
    private LocalDateTime dateFinish;
    @Column(value = "flight_time")
    private Double flightTime;

    @Column(value = "route")
    private String routeName;

    @Column(value = "work_time")
    private Integer workTime;
    @Column(value = "position_id")
    private Long positionId;
    @Column(value = "position_name")
    private String positionName;
    @Column(value = "employee_salary")
    private Double employeeSalary;
}
