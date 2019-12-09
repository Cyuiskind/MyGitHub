create database SHANHAI;
use SHANHAI;
alter database SHANHAI default character set utf8;
create table user(
	userid int not null primary key auto_increment,
	username varchar(40) not null,
    upassword varchar(16) not null,
    phonenum char(11) not null,
    userclass enum('初级传承者','中级传承者','文化传承先锋','文化传承大师','非文化遗产传承人') default '初级传承者',
    userimg blob ,
    selfintro varchar(100),
    userplace varchar(20),
    pageimg blob,
    likenum int default 0 ,
    fannum int default 0 ,
    photonum int default 0,
    videonum int default 0,
    contactnum int default 0 ,
    momentnum int default 0);
    
create table ilike(
	likeid int primary key auto_increment,
	likerid int,
    likedid int,
    foreign key (likerid) references user(userid)
	on delete cascade
    on update cascade,
    foreign key (likedid) references user(userid)
	on delete cascade
    on update cascade);
    
create table moment(  -- 瞬间、讨论、转发整合
	momentid int  primary key auto_increment,
	posterid int not null,
    momenttype enum('moment','discuss','share'),
    momparentid int default -1,
    momentday date ,
    momenttime time ,
    comentcontent varchar(300),
    momentimg1 blob,
    momentimg2 blob,
    momentimg3 blob,
    momentimg4 blob,
    momentimg5 blob,
    momentimg6 blob,
    momentimg7 blob,
    momentimg8 blob,
    momentimg9 blob,
    video1 blob,
    video2 blob,
    video3 blob,
    likenum int default 0 ,
    commentnum int default 0,
    sharenum int default 0,
    foreign key (posterid) references user(userid)
    on delete cascade
    on update cascade
    );
    
    
create table comzan(   -- 赞和评论整合
	czid int primary key auto_increment,
    cztype enum('zan','comment'),
    parentid int default -1,
	czerid int not null,
    comtext varchar(150),
    comimag blob,
    momid int not null,
    foreign key (czid) references user(userid)
	on delete cascade
    on update cascade,
    foreign key (momid) references moment(momentid)
	on delete cascade
    on update cascade,
    momcztime time,
    momczday date);
    
    
create table discussmake( -- 话题发布
	disid int primary key auto_increment,
    discontent varchar(200),
    dismakeday date,
    dismaketime time,
    postnum int default 0 ,
    makerid int ,
    foreign key (makerid) references user(userid));
    

    

    