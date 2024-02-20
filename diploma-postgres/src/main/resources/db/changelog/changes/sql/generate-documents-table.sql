insert into documents (series, number, document_type_id
)
select
    random_between(1000, 9999),
    random_between(100000, 999999),
    random_between(1, 2)
from generate_series(1, 499999) s(i)