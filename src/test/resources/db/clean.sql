-- clear all data in table
delete from sbpt.car;
-- reset sequence to initial
select setval('sbpt.car_id_seq', MAX(id) + 1) FROM sbpt.car;