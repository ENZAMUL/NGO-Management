/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 5.5.39 : Database - ngosystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ngosystem` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ngosystem`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `acc_code_number` varchar(255) DEFAULT NULL,
  `acc_hold_age` int(11) NOT NULL,
  `acc_hold_name` varchar(255) NOT NULL,
  `account_namber` bigint(20) NOT NULL,
  `acc_open_date` datetime NOT NULL,
  `address` varchar(255) NOT NULL,
  `balance_amount` double NOT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `nid_number` varchar(255) NOT NULL,
  `pri_dep_amount` double NOT NULL,
  `profession` varchar(255) NOT NULL,
  `total_withdraw` double NOT NULL,
  `account_type_id` bigint(20) NOT NULL,
  `branch_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hb8ofqht4k0kn4rnr29ayem5w` (`mobile`),
  UNIQUE KEY `UK_jyq7nen0yri1atuel58ix7v12` (`nid_number`),
  KEY `FKgw84mgpacw9htdxcs2j1p7u6j` (`account_type_id`),
  KEY `FKcwcof6gi0txp7t7mow4ii4584` (`branch_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `account` */

/*Table structure for table `account_nominee` */

DROP TABLE IF EXISTS `account_nominee`;

CREATE TABLE `account_nominee` (
  `account_id` bigint(20) NOT NULL,
  `nominee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`account_id`,`nominee_id`),
  KEY `FKlotytbu00m7vvoj70ur23fgm1` (`nominee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `account_nominee` */

/*Table structure for table `account_summary` */

DROP TABLE IF EXISTS `account_summary`;

CREATE TABLE `account_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avail_depo_amount` double NOT NULL,
  `c_loan_amount` double NOT NULL,
  `c_loan_due_amount` double NOT NULL,
  `c_loan_paid_amount` double NOT NULL,
  `n_loan_due` int(11) NOT NULL,
  `n_loan_paid` int(11) NOT NULL,
  `n_loan_taken` int(11) NOT NULL,
  `p_in_depo_amount` double NOT NULL,
  `t_depo_amount` double NOT NULL,
  `t_dep_amount_wprofit` double NOT NULL,
  `t_loan_amount` double NOT NULL,
  `t_loan_due_amount` double NOT NULL,
  `t_loan_paid_amount` double NOT NULL,
  `wid_depo_amount` double NOT NULL,
  `account_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3wgsny85j91f2wt6rj6md340q` (`account_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `account_summary` */

/*Table structure for table `account_type` */

DROP TABLE IF EXISTS `account_type`;

CREATE TABLE `account_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1wp5ealijm833490oiahqw6j6` (`type_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `account_type` */

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_address` varchar(255) NOT NULL,
  `branch_code` varchar(255) NOT NULL,
  `branch_name` varchar(255) NOT NULL,
  `ngo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbolrn2605vp0l55luj2ubv93k` (`ngo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `branch` */

/*Table structure for table `collection` */

DROP TABLE IF EXISTS `collection`;

CREATE TABLE `collection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `collect_kisti_no` int(11) NOT NULL,
  `collection_date` datetime DEFAULT NULL,
  `ngo_collect_amount` double NOT NULL,
  `ngo_total_amount` double NOT NULL,
  `account_id` bigint(20) NOT NULL,
  `branch_id` bigint(20) NOT NULL,
  `coll_type_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `loan_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt2jkf2613je804kue2h9a978w` (`account_id`),
  KEY `FKcelqmru6om8o7peeiqt7n31na` (`branch_id`),
  KEY `FK1nrw8u1vooboi6ul87pmv50yx` (`coll_type_id`),
  KEY `FKbaraxpyub6v4yagjn45tgono3` (`employee_id`),
  KEY `FKs4iyo5jlut88c75rty8mc7ame` (`loan_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `collection` */

/*Table structure for table `collection_type` */

DROP TABLE IF EXISTS `collection_type`;

CREATE TABLE `collection_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_33msr6cg0njte363etjre19hp` (`type_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `collection_type` */

/*Table structure for table `deposit` */

DROP TABLE IF EXISTS `deposit`;

CREATE TABLE `deposit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deposit_amount` double NOT NULL,
  `deposit_branch` varchar(255) NOT NULL,
  `deposit_date` datetime DEFAULT NULL,
  `loan_code_number` bigint(20) NOT NULL,
  `account_id` bigint(20) NOT NULL,
  `deposit_type_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6mvdc0k7kv0bbc40xhopj0662` (`deposit_branch`),
  KEY `FKe34nq4hsa7674ucejmcx5953l` (`account_id`),
  KEY `FK5ueo9emlnsmq1nt9ixpu3qvof` (`deposit_type_id`),
  KEY `FKorb5hvcaak0ddl0s1h0tt6lm6` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `deposit` */

/*Table structure for table `diposit_type` */

DROP TABLE IF EXISTS `diposit_type`;

CREATE TABLE `diposit_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_no4s87b3optnwrp35f9vnct8a` (`type_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `diposit_type` */

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_mobile` varchar(255) NOT NULL,
  `employee_age` int(11) NOT NULL,
  `employee_code` varchar(255) NOT NULL,
  `employee_gender` varchar(255) NOT NULL,
  `employee_name` varchar(255) NOT NULL,
  `employee_nid` varchar(255) NOT NULL,
  `employee_salary` varchar(255) NOT NULL,
  `employee_address` varchar(255) NOT NULL,
  `regi_date` datetime DEFAULT NULL,
  `branch_id` bigint(20) NOT NULL,
  `emp_type_id` bigint(20) NOT NULL,
  `ngo_id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_70okqib3h08m5eb1jdwld7bu9` (`employee_code`),
  UNIQUE KEY `UK_3edf7o66hck0vxx3sp02ib4gg` (`employee_nid`),
  KEY `FKcvhlsx8tao1rxt7mpxrot61jt` (`branch_id`),
  KEY `FKhr62k4c1r078j1pfdlevamp7y` (`emp_type_id`),
  KEY `FKiy8r2rgis4gqry61htawa6kpr` (`ngo_id`),
  KEY `FK6lk0xml9r7okjdq0onka4ytju` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employee` */

/*Table structure for table `employee_type` */

DROP TABLE IF EXISTS `employee_type`;

CREATE TABLE `employee_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3pq045th3gd8q4w574fqaow85` (`type_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employee_type` */

/*Table structure for table `loan` */

DROP TABLE IF EXISTS `loan`;

CREATE TABLE `loan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loan_amount` double NOT NULL,
  `loan_code` varchar(255) NOT NULL,
  `loan_date` datetime NOT NULL,
  `loan_payable_kisti` varchar(255) NOT NULL,
  `no_loan_kisti` int(11) NOT NULL,
  `account_id` bigint(20) NOT NULL,
  `branch_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgv9cgsh4k76wmaf83ktoekpub` (`account_id`),
  KEY `FKlxeysvpbcvv0a19elbalbv5ca` (`branch_id`),
  KEY `FKldelgmf98lfdsspa79vo5syqb` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `loan` */

/*Table structure for table `loan_type` */

DROP TABLE IF EXISTS `loan_type`;

CREATE TABLE `loan_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6kulswdj0m8oe6kgwfyj49w2n` (`type_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `loan_type` */

/*Table structure for table `ngo` */

DROP TABLE IF EXISTS `ngo`;

CREATE TABLE `ngo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `ngo_email` varchar(255) NOT NULL,
  `ngo_mobile` varchar(255) NOT NULL,
  `ngo_name` varchar(255) NOT NULL,
  `ngo_regi_date` datetime DEFAULT NULL,
  `ngo_service` varchar(255) DEFAULT NULL,
  `ngo_owner` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t9xvr0d9ejvltqvim5s96leeg` (`address`),
  UNIQUE KEY `UK_p5a8ylnjqq6ityrptd0aal8uw` (`ngo_email`),
  UNIQUE KEY `UK_10fq7a6yv4o5lxpf9r8c2bv82` (`ngo_mobile`),
  UNIQUE KEY `UK_bferc8hgj0yki6388hhlejwgh` (`ngo_name`),
  UNIQUE KEY `UK_agvjqlemf0fs083d8ufvjirvv` (`ngo_owner`),
  UNIQUE KEY `UK_ejpw85n1fqr7mvjeysow69rgv` (`ngo_service`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `ngo` */

/*Table structure for table `nominee` */

DROP TABLE IF EXISTS `nominee`;

CREATE TABLE `nominee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomi_address` varchar(255) NOT NULL,
  `nomi_age` int(11) NOT NULL,
  `nomi_birth_date` date NOT NULL,
  `nomi_gender` varchar(255) NOT NULL,
  `nomi_mobile` varchar(255) NOT NULL,
  `nomi_name` varchar(255) NOT NULL,
  `nomi_nid` varchar(255) NOT NULL,
  `nomi_relation` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ig56mefmfuu02dmf7h4wd9f67` (`nomi_nid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `nominee` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iubw515ff0ugtm28p8g3myt0h` (`role_name`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`id`,`role_name`) values 
(1,'admin'),
(2,'user'),
(3,'superadmin');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `age` tinyint(4) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `conformation_token` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `regi_date` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_n09rrji29tedrsrsmxkh9a2ec` (`first_name`),
  UNIQUE KEY `UK_qct51p6rq4j43jokn6wp42e5b` (`last_name`),
  UNIQUE KEY `UK_cnjwxx5favk5ycqajjt17fwy1` (`mobile`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`address`,`age`,`birth_date`,`conformation_token`,`email`,`first_name`,`gender`,`last_modified_date`,`last_name`,`mobile`,`password`,`regi_date`,`status`,`user_name`) values 
(1,'dhaka',25,'1994-12-09','8cbfda3f-6caa-4b5d-b52f-366c75f42276','abucollege@gmail.com','amjad','male','2020-03-16 11:58:46','mia','01672892356','$2a$10$DC0SnTSPzRQQqAdCjOqKk.4wid4lwadkNuseb3NQHslwHwegsXZWa','2020-03-16 11:58:46','','amjad');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values 
(1,3);

/*Table structure for table `withdraw_deposit` */

DROP TABLE IF EXISTS `withdraw_deposit`;

CREATE TABLE `withdraw_deposit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `withdraw_date` datetime NOT NULL,
  `account_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9visu7tpq0perse0wlxa24pyf` (`account_id`),
  KEY `FKmw2nfs0kufxssurh0fdrqqkxm` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `withdraw_deposit` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
