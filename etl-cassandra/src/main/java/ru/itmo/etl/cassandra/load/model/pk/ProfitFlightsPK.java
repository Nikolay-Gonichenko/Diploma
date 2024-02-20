package ru.itmo.etl.cassandra.load.model.pk;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class ProfitFlightsPK implements Serializable {

    @PrimaryKeyColumn(name = "flight_id", type = PrimaryKeyType.PARTITIONED)
    private Long flight;

    @PrimaryKeyColumn(name = "employee_id", type = PrimaryKeyType.CLUSTERED)
    private Long employee;

    @PrimaryKeyColumn(name = "route_id", type = PrimaryKeyType.CLUSTERED)
    private Long route;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProfitFlightsPK that)) {
            return false;
        }
        return Objects.equals(getFlight(), that.getFlight())
                && Objects.equals(getEmployee(), that.getEmployee())
                && Objects.equals(getRoute(), that.getRoute());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlight(), getEmployee(), getRoute());
    }
}
