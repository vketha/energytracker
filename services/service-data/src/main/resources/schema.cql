
CREATE KEYSPACE energytracker WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

use energytracker; 

create table if not exists device (
	id timeuuid,
	name text,
	home_id timeuuid, 
	additional_info map<text, text>, 
	primary key (home_id, id)
) WITH CLUSTERING ORDER BY(id desc); 

create table if not exists home (
	id timeuuid,
	name text,
	additional_info map<text, text>, 
	primary key (id, name)
) WITH CLUSTERING ORDER BY(name asc); 

create table if not exists device_reading (
	device_id timeuuid,
	home_id timeuuid,
	reading double,
	units text,
	date date,
	additional_info map<text, text>, 
	primary key ((home_id, device_id), date)
) WITH CLUSTERING ORDER BY(date asc);  