package ru.itmo.etl.cassandra.load.model.pk;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@PrimaryKeyClass
public class AgeGroupedByFlightFrequencyPK implements Serializable {

    @PrimaryKeyColumn(name = "age", type = PrimaryKeyType.PARTITIONED)
    private Integer age;

    @PrimaryKeyColumn(name = "route", type = PrimaryKeyType.PARTITIONED)
    private String route;

    @PrimaryKeyColumn(name = "month", type = PrimaryKeyType.CLUSTERED)
    private String month;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AgeGroupedByFlightFrequencyPK that)) {
            return false;
        }
        return Objects.equals(getAge(), that.getAge())
                && Objects.equals(getRoute(), that.getRoute())
                && Objects.equals(getMonth(), that.getMonth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getRoute(), getMonth());
    }
}
