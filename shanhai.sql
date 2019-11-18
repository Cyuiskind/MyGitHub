create database SHANHAI;
use SHANHAI;
alter database SHANHAI default character set utf8;
create table user(
	userid int not null primary key,
	username varchar(40) not null,
    upassword varchar(16) not null,
    phonenum char(11) not null,
    userclass enum('初级传承者','中级传承者','文化传承先锋','文化传承大师','非文化遗产传承人') default '初级传承者'  not null,
    userimg blob not null,
    selfintro varchar(100),
    userplace varchar(20),
    pageimg blob,
    likenum int default 0 not null,
    fannum int default 0 not null,
    photonum int default 0 not null,
    videonum int default 0 not null,
    contactnum int default 0 not null,
    momentnum int default 0 not null);
    
create table ilike(
	likeid int not null primary key,
	likerid int,
    likedid int,
    foreign key (likerid) references user(userid),
    foreign key (likedid) references user(userid));
    
create table moment(  -- 瞬间、讨论、转发整合
	momentid int not null primary key,
	posterid int not null,
    momenttype enum('moment','discuss','share'),
    momparentid int default -1,
    momentday date not null,
    momenttime time not null,
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
    likenum int default 0 not null,
    commentnum int default 0 not null,
    sharenum int default 0 not null,
    foreign key (posterid) references user(userid));
    
    
create table comzan(   -- 赞和评论整合
	czid int primary key,
    cztype enum('zan','comment'),
    parentid int default -1,
	czerid int not null,
    comtext varchar(150),
    comimag blob,
    momid int not null,
    foreign key (czid) references user(userid),
    foreign key (momid) references moment(momentid),
    momcztime time not null,
    momczday date not null);
    
    
create table discussmake( -- 话题发布
	disid int primary key,
    discontent varchar(200),
    dismakeday date not null,
    dismaketime time not null,
    postnum int default 0 not null,
    makerid int ,
    foreign key (makerid) references user(userid));
    

    

    