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

 Date: 07/01/2020 14:22:29
*/


-- ----------------------------
-- Table structure for t_sims_device
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_sims_device";
CREATE TABLE "public"."t_sims_device" (
  "c_id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "c_name" varchar(300) COLLATE "pg_catalog"."default",
  "c_proid" varchar(32) COLLATE "pg_catalog"."default",
  "c_userid" varchar(32) COLLATE "pg_catalog"."default",
  "c_sbmy" varchar(300) COLLATE "pg_catalog"."default",
  "n_sfyx" int4,
  "n_sfzx" int4,
  "c_dtmm" varchar(300) COLLATE "pg_catalog"."default",
  "n_ycms" int4,
  "n_jljzt" int4,
  "n_jmjzt" int4,
  "n_sbzt" int4,
  "n_bgdzt" int4,
  "n_dcfzt" int4,
  "n_yxms" int4,
  "n_dpjljzt" int4,
  "d_cjsj" timestamp(6),
  "d_xgsj" timestamp(6),
  "c_cjr" varchar(32) COLLATE "pg_catalog"."default",
  "c_xgr" varchar(32) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."t_sims_device"."c_id" IS '设备id';
COMMENT ON COLUMN "public"."t_sims_device"."c_name" IS '设备名称';
COMMENT ON COLUMN "public"."t_sims_device"."c_proid" IS '产品id';
COMMENT ON COLUMN "public"."t_sims_device"."c_userid" IS '用户id';
COMMENT ON COLUMN "public"."t_sims_device"."c_sbmy" IS '设备秘钥';
COMMENT ON COLUMN "public"."t_sims_device"."n_sfyx" IS '是否有效';
COMMENT ON COLUMN "public"."t_sims_device"."n_sfzx" IS '是否在线';
COMMENT ON COLUMN "public"."t_sims_device"."c_dtmm" IS '设备动态密码';
COMMENT ON COLUMN "public"."t_sims_device"."n_ycms" IS '远程模式1开启0关闭';
COMMENT ON COLUMN "public"."t_sims_device"."n_jljzt" IS '卷帘机状态0停在中间 1上行 2停止 3下行 4下行停止';
COMMENT ON COLUMN "public"."t_sims_device"."n_jmjzt" IS '卷膜机状态0停在中间 1上行 2停止 3下行 4下行停止';
COMMENT ON COLUMN "public"."t_sims_device"."n_sbzt" IS '水泵状态 1开启 0关闭';
COMMENT ON COLUMN "public"."t_sims_device"."n_bgdzt" IS '补光灯1开启 0关闭';
COMMENT ON COLUMN "public"."t_sims_device"."n_dcfzt" IS '电磁阀 1 2 3 4  0关闭';
COMMENT ON COLUMN "public"."t_sims_device"."n_yxms" IS '运行模式 0手动模式 1自动模式';
COMMENT ON COLUMN "public"."t_sims_device"."n_dpjljzt" IS '大棚卷帘机状态0中间 1停在顶端 2停在底端';
COMMENT ON COLUMN "public"."t_sims_device"."d_cjsj" IS '创建时间';
COMMENT ON COLUMN "public"."t_sims_device"."d_xgsj" IS '修改时间';
COMMENT ON COLUMN "public"."t_sims_device"."c_cjr" IS '创建人id';
COMMENT ON COLUMN "public"."t_sims_device"."c_xgr" IS '修改人id';
