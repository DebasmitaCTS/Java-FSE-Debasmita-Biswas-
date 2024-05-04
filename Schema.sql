create table vechicle_types (
 id integer not null,  type integer,max_passengers_allowed integer,fare_perkm integer,  primary key (id));
 
create table vechicles (registration_no varchar(255)  primary key,
belongs_to_user_id integer, 
vechicle_type_id integer,
inspection_status varchar(255),
inspected_by_user_id integer,
inspected_on date);

create table vechile_details ( registration_no varchar(255)primary key,
rtoname varchar(255),
registration_date date, 
registration_expires_on date,
rcdocurl varchar(255), 
insurance_company_name varchar(255),
insurance_no integer,
insuranced_on date,
insurance_expires_on date,
insurance_certificatedocurl varchar(255),  
puccertificate_no integer,
pucissued_on date, pucvalid_until date,
pucdocurl varchar(255));
 
 