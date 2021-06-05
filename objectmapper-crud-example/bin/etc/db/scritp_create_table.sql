create database rm_test_db; -- Creates the new database
create database rm_prod_db; -- Creates the new database
create database rm_dev_db; -- Creates the new database

create user 'rmuser'@'%' identified by 'rmuser'; -- Creates the user
grant all on rm_test_db.* to 'rmuser'@'%'; -- Gives all privileges to the new user on the newly created database
grant all on rm_prod_db.* to 'rmuser'@'%'; -- Gives all privileges to the new user on the newly created database
grant all on rm_dev_db.* to 'rmuser'@'%'; -- Gives all privileges to the new user on the newly created database