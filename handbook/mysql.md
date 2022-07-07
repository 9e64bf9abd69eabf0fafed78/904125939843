# 安装

---

- wget http://repo.mysql.com/mysql-community-release-el7-5.noarch.rpm

- rpm -ivh mysql-community-release-el7-5.noarch.rpm （会替换掉MariaDb）

- yum update

- yum install mysql-server

# 启动

---

- chown mysql:mysql -R /var/lib/mysql

- mysqld --initialize --console

- vim /etc/my.cnf

- [mysqld]下添加 character-set-server=utf8mb4

- systemctl restart mysqld

# 设置root密码

---

mysqladmin -u root password "密码";

# 忘记root密码

---

- vim /etc/my.cnf

- [mysqld]下添加skip-grant-tables

- systemctl restart mysqld

- mysql -u root -p

- 空密码回车

- UPDATE mysql.user SET authentication_string=PASSWORD('密码') WHERE USER='root';

FLUSH PRIVILEGES;

mysqld下注释

    skip-grant-tables

systemctl restart mysqld

# 创建数据库

---

CREATE DATABASE 数据库 DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;

# 新建用户

---

CREATE USER 用户名 IDENTIFIED BY '密码' WITH MAX_CONNECTIONS_PER_HOUR 小时最大连接 MAX_UPDATES_PER_HOUR 小时最大更新 MAX_USER_CONNECTIONS 最大用户连接;

# 授权

---

8 ：GRANT ALL PRIVILEGES ON 数据库.* TO 用户@'%';

FLUSH PRIVILEGES;

# 取消授权

---
8 ：REVOKE ALL PRIVILEGES ON 数据库.* FROM '用户'@'%' ;

FLUSH PRIVILEGES;

# 修改密码

---
ALTER USER '用户'@'%' IDENTIFIED WITH mysql_native_password BY '密码';

FLUSH PRIVILEGES;

# 按字段重复删除数据

---
delete from 数据表 where 去重字段 in (select 去重字段 from (select 去重字段 from 数据表 group by 去重字段 having count(去重字段) > 1) as duplicate) and 参考字段 not in (select X from (select min(参考字段) as X from 数据表 group by 去重字段
having count(去重字段) > 1) as retain);

# 分组后保留最大ID

---
SELECT max(id), 分组字段,any_value(未分组字段) FROM 表 GROUP BY 分组字段

# 寻找中位数

---
SELECT AVG(DISTINCT a.字段)
FROM (
SELECT a.字段 FROM 表 AS a, 表 AS b GROUP BY a.字段 HAVING SUM(IF(b.字段 >= a.字段, 1, 0)) >= COUNT(*) / 2 AND SUM(IF(b.字段 <= a.字段, 1, 0)) >= COUNT(*) / 2) AS a;