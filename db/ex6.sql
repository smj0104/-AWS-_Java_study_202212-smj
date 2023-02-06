create view user_view as
select
	id,
    username,
    password,
    name,
    email
from
	user_mst
where
	id between 1 and 200;
    
select
	*
from
	user_view
where
	username = 'a';