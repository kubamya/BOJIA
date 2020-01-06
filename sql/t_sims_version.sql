/*
 Navicat Premium Data Transfer

 Source Server         : localhost练习库
 Source Server Type    : PostgreSQL
 Source Server Version : 100005
 Source Host           : localhost:5432
 Source Catalog        : postgres
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 100005
 File Encoding         : 65001

 Date: 03/01/2020 17:36:40
*/


-- ----------------------------
-- Table structure for t_sims_version
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sims_version";
CREATE TABLE "public"."t_sims_version" (
  "c_version" varchar(300) COLLATE "pg_catalog"."default" NOT NULL,
  "c_name" varchar(300) COLLATE "pg_catalog"."default",
  "d_fbsj" timestamp(6)
)
;
COMMENT ON COLUMN "public"."t_sims_version"."c_version" IS '版本号';
COMMENT ON COLUMN "public"."t_sims_version"."c_name" IS '版本名';
COMMENT ON COLUMN "public"."t_sims_version"."d_fbsj" IS '发布时间';
