SELECT * FROM test.state;

SELECT * FROM test.role;

SELECT * FROM test.worker;

SELECT * FROM test.issue;

SELECT *
FROM test.issue i,
	 test.worker w
where w.id = i.responsible
and w.first_name = 'Federico'; 

update test.issue
set responsible = 2
where id = 2;
commit;

