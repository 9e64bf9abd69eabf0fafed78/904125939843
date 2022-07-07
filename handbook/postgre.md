# postgresql

---

## 安装

-
    1. https://www.postgresql.org/download/linux/redhat/

    -
        1. sudo yum install -y https://download.postgresql.org/pub/repos/yum/reporpms/EL-7-x86_64/pgdg-redhat-repo-latest.noarch.rpm

    -
        2. sudo yum install -y postgresql13-server

    -
        3. sudo /usr/pgsql-13/bin/postgresql-13-setup initdb

    -
        4. sudo systemctl enable postgresql-13

    -
        5. vim /var/lib/pgsql/13/data/postgresql.conf

    -
        6. vim /var/lib/pgsql/13/data/pg_hba.conf

    -
        7. systemctl start postgresql-13

-
    2. su postgres

-
    3. psql

-
    4. create user 用户 with password '密码';

-
    5. create database 数据库 owner 用户;

-
    6. grant all on database 数据库 to 用户;

-
    7. grant update,select,insert on 表 to 用户;

-
    8. revoke update,select,insert on 表 from 用户;

-
    9. vim /var/lib/pgsql/13/data/pg_hba.conf

-
    10. systemctl restart postgresql-13

## 重置自增ID

-
    1. SELECT MAX(id) FROM table;

-
    2. SELECT nextval('table_id_seq');

-
    3. SELECT setval('table_id_seq', (SELECT MAX(id) FROM table));

-
    4. SELECT nextval('table_id_seq');