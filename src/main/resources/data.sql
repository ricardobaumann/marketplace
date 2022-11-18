truncate table gig cascade;

insert into gig (id, title, description)
values ('1', 'Test1', 'this is a test');

insert into gig (id, title, description)
values ('2', 'Test2', 'this is a test');

insert into gig_tags (gig_id, tag)
select id, title
from gig;