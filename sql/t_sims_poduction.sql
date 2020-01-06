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

 Date: 06/01/2020 16:16:56
*/


-- ----------------------------
-- Table structure for t_sims_poduction
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sims_poduction";
CREATE TABLE "public"."t_sims_poduction" (
  "c_id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "c_name" varchar(300) COLLATE "pg_catalog"."default",
  "n_yx" int4,
  "n_type" int4,
  "c_cjr" varchar(32) COLLATE "pg_catalog"."default",
  "c_xgr" varchar(32) COLLATE "pg_catalog"."default",
  "d_cjsj" timestamp(6),
  "d_xgsj" timestamp(6)
)
;
COMMENT ON COLUMN "public"."t_sims_poduction"."c_id" IS '产品id';
COMMENT ON COLUMN "public"."t_sims_poduction"."c_name" IS '产品名称';
COMMENT ON COLUMN "public"."t_sims_poduction"."n_yx" IS '是否有效';
COMMENT ON COLUMN "public"."t_sims_poduction"."n_type" IS '产品类型';
COMMENT ON COLUMN "public"."t_sims_poduction"."c_cjr" IS '创建人id';
COMMENT ON COLUMN "public"."t_sims_poduction"."c_xgr" IS '修改人id';
COMMENT ON COLUMN "public"."t_sims_poduction"."d_cjsj" IS '创建时间';
COMMENT ON COLUMN "public"."t_sims_poduction"."d_xgsj" IS '修改时间';
