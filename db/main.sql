/*
 Navicat Premium Data Transfer

 Source Server         : mo
 Source Server Type    : SQLite
 Source Server Version : 3021000
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3021000
 File Encoding         : 65001

 Date: 17/09/2019 17:18:20
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS "feedback";
CREATE TABLE "feedback" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" TEXT,
  "email" TEXT,
  "mobile" TEXT,
  "qq" TEXT,
  "weixin" TEXT,
  "msg" TEXT,
  "remark" TEXT,
  "remark2" TEXT,
  "remark3" TEXT,
  "remark4" TEXT
);

-- ----------------------------
-- Table structure for showcase
-- ----------------------------
DROP TABLE IF EXISTS "showcase";
CREATE TABLE "showcase" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "title" TEXT,
  "des" TEXT,
  "content" TEXT,
  "imgs" TEXT,
  "remark" TEXT,
  "remark2" TEXT,
  "remark3" TEXT,
  "remark4" TEXT
);

-- ----------------------------
-- Records of showcase
-- ----------------------------
INSERT INTO "showcase" VALUES (1, 'XX公司', '案例简介', '详情', '我是图', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sqlite_sequence
-- ----------------------------
DROP TABLE IF EXISTS "sqlite_sequence";
CREATE TABLE "sqlite_sequence" (
  "name",
  "seq"
);

-- ----------------------------
-- Records of sqlite_sequence
-- ----------------------------
INSERT INTO "sqlite_sequence" VALUES ('showcase', 1);
INSERT INTO "sqlite_sequence" VALUES ('user', 1);
INSERT INTO "sqlite_sequence" VALUES ('feedback', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "user";
CREATE TABLE "user" (
  "id" integer NOT NULL PRIMARY KEY AUTOINCREMENT,
  "username" TEXT,
  "password" TEXT,
  "mobile" TEXT,
  "name" TEXT,
  "status" TEXT,
  "remark" TEXT,
  "remark2" TEXT,
  "remark3" TEXT,
  "remark4" TEXT
);

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "user" VALUES (1, 'w', 2, 123142, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Auto increment value for feedback
-- ----------------------------

-- ----------------------------
-- Auto increment value for showcase
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 1 WHERE name = 'showcase';

-- ----------------------------
-- Auto increment value for user
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 1 WHERE name = 'user';

PRAGMA foreign_keys = true;
