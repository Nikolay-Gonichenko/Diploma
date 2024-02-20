package ru.itmo.etl.cassandra.load.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import ru.itmo.etl.cassandra.load.model.pk.ProfitableFlightsRoutesPK;

/**
 * Сущность запроса "Самый выгодный перелёт по маршруту"
 *
 * Запрос 5.
 */
@Table(value = "profitable_flights_routes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfitableFlightsRoutes {

    @PrimaryKey
    private ProfitableFlightsRoutesPK profitableFlightsRoutesPK;

    @Column(value = "place_to")
    private String placeTo;
    @Column(value = "place_from")
    private String placeFrom;

    @Column(value = "total_cost")
    private Double totalCost;
    @Column(value = "total_expense")
    private Double totalExpense;

    @Column(value = "plane_model")
    private String planeModel;
}
