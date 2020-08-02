CREATE TABLE `blog` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`title`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cover`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`abstractContent`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`content`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`categoryId`  bigint(11) NULL DEFAULT NULL ,
`writer`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`likes`  bigint(20) NULL DEFAULT 0 COMMENT '閻愮绂愰弫?' ,
`hits`  bigint(20) NULL DEFAULT 0 COMMENT '閻愮懓鍤柌?' ,
`createdDatetime`  datetime NULL DEFAULT NULL ,
`lastModifiedDatetime`  datetime NULL DEFAULT NULL ,
`dr`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE `category` (
`id`  bigint(64) NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`num`  int(11) NULL DEFAULT NULL ,
`createdDatetime`  datetime NULL DEFAULT NULL ,
`lastModifiedDatetime`  datetime NULL DEFAULT NULL ,
`dr`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE `login_log` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`userName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ip`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`method`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`isLoginSuccess`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`browserInfo`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`loginDateTime`  datetime NULL DEFAULT NULL ,
`errorMessage`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE `portal_log` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`ip`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userAgent`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`method`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`requestDateTime`  datetime NULL DEFAULT NULL ,
`errorMessage`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`blogName`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
INDEX `index_method` (`method`) USING BTREE ,
INDEX `index_request_time` (`requestDateTime`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE `user` (
`id`  bigint(11) NOT NULL AUTO_INCREMENT ,
`userCode`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userName`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`nickName`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`email`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`telephone`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`password`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`gender`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`birthday`  date NULL DEFAULT NULL ,
`isLocked`  tinyint(4) NULL DEFAULT NULL ,
`isExpired`  tinyint(4) NULL DEFAULT NULL ,
`description`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`image`  longblob NULL ,
`createdDatetime`  datetime NULL DEFAULT NULL ,
`lastModifiedDatetime`  datetime NULL DEFAULT NULL ,
`dr`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `UNIQUE_USERCODE` (`userCode`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE `visitor_email` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`visitorEmail`  varchar(512) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`enable`  varchar(512) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`createdDatetime`  datetime NULL DEFAULT NULL ,
`lastModifiedDatetime`  datetime NULL DEFAULT NULL ,
`dr`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=utf8_general_ci;


