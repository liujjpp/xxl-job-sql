-- ----------------------------
-- Create Database
-- ----------------------------
CREATE DATABASE IF NOT EXISTS DemoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE DemoDB;

SET NAMES utf8mb4;

-- ----------------------------
-- Table structure for a_tb
-- ----------------------------
DROP TABLE IF EXISTS `a_tb`;
CREATE TABLE `a_tb` (
  `id` varchar(255) NOT NULL,
  `business_date` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for b_tb
-- ----------------------------
DROP TABLE IF EXISTS `b_tb`;
CREATE TABLE `b_tb` (
  `id` varchar(255) NOT NULL,
  `business_date` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of a_tb
-- ----------------------------
INSERT INTO `a_tb` VALUES ('A01', '20200727', 'Beijing');
INSERT INTO `a_tb` VALUES ('A02', '20200727', 'Shanghai');
INSERT INTO `a_tb` VALUES ('A03', '20200728', 'Guangzhou');
INSERT INTO `a_tb` VALUES ('A04', '20200728', 'Shenzhen');

-- ----------------------------
-- Records of b_tb
-- ----------------------------
INSERT INTO `b_tb` VALUES ('B01', '20200727', 'Guangzhou');
INSERT INTO `b_tb` VALUES ('B02', '20200727', 'Shenzhen');
INSERT INTO `b_tb` VALUES ('B03', '20200728', 'Beijing');
INSERT INTO `b_tb` VALUES ('B04', '20200728', 'Shanghai');

COMMIT;
