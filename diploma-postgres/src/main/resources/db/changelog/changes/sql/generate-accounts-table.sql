insert into accounts(nickname, password, human_id, registration_date, role_id)
select
    md5(random()::text),
    md5(random()::text),
    id,
    timestamp '2010-01-01 00:00:00' +
    random() * (timestamp '2023-05-05 00:00:00' -
                timestamp '2010-01-01 00:00:00'),
    1
from generate_series(102, 108191) id