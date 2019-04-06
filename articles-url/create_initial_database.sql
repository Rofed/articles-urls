

create table articles (id bigint not null auto_increment, description longtext, link varchar(255), time_stamp datetime, title varchar(255), source_id bigint, primary key (id)) engine=MyISAM;
create table sources (id bigint not null auto_increment, time_stamp datetime, url varchar(255), primary key (id)) engine=MyISAM;
alter table articles add constraint FKmuaiq22yogpdh0ajopqlr5x8x foreign key (source_id) references sources (id);
alter table articles add unique (title(50));
