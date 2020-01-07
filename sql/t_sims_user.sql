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

 Date: 07/01/2020 16:57:58
*/


-- ----------------------------
-- Table structure for t_sims_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sims_user";
CREATE TABLE "public"."t_sims_user" (
  "c_id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "c_loginid" varchar(300) COLLATE "pg_catalog"."default",
  "c_password" varchar(300) COLLATE "pg_catalog"."default",
  "c_username" varchar(300) COLLATE "pg_catalog"."default",
  "c_comid" varchar(32) COLLATE "pg_catalog"."default",
  "c_deptid" varchar(32) COLLATE "pg_catalog"."default",
  "c_email" varchar(300) COLLATE "pg_catalog"."default",
  "c_tel" varchar(300) COLLATE "pg_catalog"."default",
  "n_sfyx" int4,
  "n_xssx" int4,
  "d_cjsj" timestamp(6),
  "c_cjrid" varchar(32) COLLATE "pg_catalog"."default",
  "d_xgsj" timestamp(6),
  "c_xgrid" varchar(32) COLLATE "pg_catalog"."default",
  "n_type" int4
)
;
COMMENT ON COLUMN "public"."t_sims_user"."c_id" IS '主键';
COMMENT ON COLUMN "public"."t_sims_user"."c_loginid" IS '登录名';
COMMENT ON COLUMN "public"."t_sims_user"."c_password" IS '密码';
COMMENT ON COLUMN "public"."t_sims_user"."c_username" IS '用户名';
COMMENT ON COLUMN "public"."t_sims_user"."c_comid" IS '组织id';
COMMENT ON COLUMN "public"."t_sims_user"."c_deptid" IS '部门id';
COMMENT ON COLUMN "public"."t_sims_user"."c_email" IS '邮箱';
COMMENT ON COLUMN "public"."t_sims_user"."c_tel" IS '电话';
COMMENT ON COLUMN "public"."t_sims_user"."n_sfyx" IS '是否有效';
COMMENT ON COLUMN "public"."t_sims_user"."n_xssx" IS '显示顺序';
COMMENT ON COLUMN "public"."t_sims_user"."d_cjsj" IS '创建时间';
COMMENT ON COLUMN "public"."t_sims_user"."c_cjrid" IS '创建人id';
COMMENT ON COLUMN "public"."t_sims_user"."d_xgsj" IS '修改时间';
COMMENT ON COLUMN "public"."t_sims_user"."c_xgrid" IS '修改人id';
COMMENT ON COLUMN "public"."t_sims_user"."n_type" IS '用户类型0客户1用户';

-- ----------------------------
-- Records of t_sims_user
-- ----------------------------
INSERT INTO "public"."t_sims_user" VALUES ('000', 'admin', '202cb962ac59075b964b07152d234b70', '超管_Urttom', '0000', '333', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);
