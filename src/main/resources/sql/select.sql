select u.lastname, u.firstname, u.patronimyc, tfv.value from contract
  inner join type_field_values tfv on contract.contract_id = tfv.contract_id
  inner join users u on contract.user_id = u.user_id
where contract.type_id = 20
and now()::date >= contract.start_date and now()::date <= contract.finish_date;

select users.lastname, users.firstname, users.patronimyc
from users
inner join contract c on users.user_id = c.user_id ORDER BY c.amount DESC
LIMIT 1;

select ct.name, count(type_id)
from contract
  left join contract_types ct on contract.type_id = ct.contract_type_id
where now()::date >= start_date and now()::date <= finish_date
group by ct.contract_type_id;
