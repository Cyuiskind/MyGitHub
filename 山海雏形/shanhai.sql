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
    
ALTER TABLE `shanhai`.`user` 
CHANGE COLUMN `pageimg` `pageimg` VARCHAR(150) NULL DEFAULT NULL;
    
ALTER TABLE `shanhai`.`user` 
CHANGE COLUMN `userimg` `userimg` VARCHAR(150) NULL DEFAULT NULL;

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
    

ALTER TABLE `shanhai`.`moment` 
ADD COLUMN `title` VARCHAR(100) NULL AFTER `sharenum`;

ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `momentimg1` `momentimg1` varchar(150) NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `momentimg2` `momentimg2` varchar(150) NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `momentimg3` `momentimg3` varchar(150) NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `momentimg4` `momentimg4` LONGBLOB NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `momentimg5` `momentimg5` LONGBLOB NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `momentimg6` `momentimg6` LONGBLOB NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `momentimg7` `momentimg7` LONGBLOB NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `momentimg8` `momentimg8` LONGBLOB NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `momentimg9` `momentimg9` LONGBLOB NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `video1` `video1` LONGBLOB NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `video2` `video2` LONGBLOB NULL DEFAULT NULL ;
ALTER TABLE `shanhai`.`moment` 
CHANGE COLUMN `video3` `video3` LONGBLOB NULL DEFAULT NULL ;

ALTER TABLE `shanhai`.`moment` 
DROP FOREIGN KEY `FKC04F8200EA3A6025`;
ALTER TABLE `shanhai`.`moment` 
ADD CONSTRAINT `FKC04F8200EA3A6025`
  FOREIGN KEY (`posterid`)
  REFERENCES `shanhai`.`user` (`userid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  ALTER TABLE `shanhai`.`ilike` 
DROP FOREIGN KEY `FK5FA5380C7748E85`;
ALTER TABLE `shanhai`.`ilike` 
ADD CONSTRAINT `FK5FA5380C7748E85`
  FOREIGN KEY (`likedid`)
  REFERENCES `shanhai`.`user` (`userid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `shanhai`.`ilike` 
DROP FOREIGN KEY `FK5FA5380C7748E85`,
DROP FOREIGN KEY `FK5FA5380C774C313`;
ALTER TABLE `shanhai`.`ilike` 
ADD CONSTRAINT `FK5FA5380C7748E85`
  FOREIGN KEY (`likedid`)
  REFERENCES `shanhai`.`user` (`userid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK5FA5380C774C313`
  FOREIGN KEY (`likerid`)
  REFERENCES `shanhai`.`user` (`userid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `shanhai`.`discussmake` 
DROP FOREIGN KEY `discussmake_ibfk_1`;
ALTER TABLE `shanhai`.`discussmake` 
ADD CONSTRAINT `discussmake_ibfk_1`
  FOREIGN KEY (`makerid`)
  REFERENCES `shanhai`.`user` (`userid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `shanhai`.`discussmake` 
DROP FOREIGN KEY `discussmake_ibfk_1`,
DROP FOREIGN KEY `FK1A4569CEEEB4395C`;
ALTER TABLE `shanhai`.`discussmake` 
ADD CONSTRAINT `discussmake_ibfk_1`
  FOREIGN KEY (`makerid`)
  REFERENCES `shanhai`.`user` (`userid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FK1A4569CEEEB4395C`
  FOREIGN KEY (`makerid`)
  REFERENCES `shanhai`.`user` (`userid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  ALTER TABLE `shanhai`.`comzan` 
DROP FOREIGN KEY `FKAF3F5906BD424CCF`;
ALTER TABLE `shanhai`.`comzan` 
ADD CONSTRAINT `FKAF3F5906BD424CCF`
  FOREIGN KEY (`czid`)
  REFERENCES `shanhai`.`user` (`userid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  ALTER TABLE `shanhai`.`comzan` 
DROP FOREIGN KEY `FKAF3F5906BD424CCF`,
DROP FOREIGN KEY `FKAF3F5906BE62A418`;
ALTER TABLE `shanhai`.`comzan` 
ADD CONSTRAINT `FKAF3F5906BD424CCF`
  FOREIGN KEY (`czid`)
  REFERENCES `shanhai`.`user` (`userid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `FKAF3F5906BE62A418`
  FOREIGN KEY (`momid`)
  REFERENCES `shanhai`.`moment` (`momentid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

DELIMITER $$
DROP TRIGGER IF EXISTS shanhai.zan_after_insert_moment$$
CREATE TRIGGER `shanhai`.`zan_after_insert_moment` AFTER INSERT 
ON `comzan` FOR EACH ROW
BEGIN
   if(new.cztype=`zan`)
  then
  update moment set likenum=likenum+1 where momentid=new.momid;
  else
  update moment set commentnum=commentnum+1 where momentid=new.momid;
  end if;
end$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS shanhai.zan_after_insert_moment$$
CREATE TRIGGER `shanhai`.`share_after_insert_moment` AFTER INSERT 
ON `moment` FOR EACH ROW
BEGIN
   if(new.momenttype=`share`)
  then
  update moment set sharenum=sharenum+1 where momentid=new.momparentid;
  end if;
end$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS shanhai.zan_after_insert_moment$$
DELIMITER ;