insert into options(option_type_id, ticket_id)
select
    random_between(1, 4),
    random_between(1, 14993970)
from generate_series(1, 20000000);