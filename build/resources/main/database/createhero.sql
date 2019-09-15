SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heroes (
  id int PRIMARY KEY auto_increment,
  hero_name VARCHAR,
  age int,
  squad VARCHAR,
  powers VARCHAR,
  weakness VARCHAR,
);