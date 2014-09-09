 CREATE TABLE t_user(
user_id INT AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(30),
credits INT,
PASSWORD VARCHAR(32),
last_visit DATETIME,
last_ip VARCHAR(23)
);

CREATE TABLE t_login_log(
   login_log_id INT AUTO_INCREMENT PRIMARY KEY,
   user_id INT,
   ip VARCHAR(23),
   login_datetime DATETIME
);

INSERT INTO t_user(user_name,PASSWORD) VALUES ('admin','123456');
COMMIT;