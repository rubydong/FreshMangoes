drop database cse308;
create database cse308 CHARACTER set utf8mb4 collate utf8mb4_unicode_ci;
use cse308;

CREATE TABLE Media(
  id INT AUTO_INCREMENT,
  media_type TINYINT,
  path VARCHAR(256),
  PRIMARY KEY(id)
);

CREATE TABLE Users(
  display_name VARCHAR(256) NOT NULL DEFAULT '',
  email VARCHAR(256) NOT NULL DEFAULT '',
  hash CHAR(60) NOT NULL,
  id INT AUTO_INCREMENT,
  profile_picture INT,
  user_type TINYINT,
  PRIMARY KEY(id),
  FOREIGN KEY(profile_picture) REFERENCES Media(id)
);

CREATE TABLE Followings(
  followee_id INT,
  follower_id INT,
  PRIMARY KEY(follower_id, followee_id),
  FOREIGN KEY(follower_id) REFERENCES Users(id),
  FOREIGN KEY(followee_id) REFERENCES Users(id)
);

CREATE TABLE Celebrities(
  birthday DATE NOT NULL,
  birthplace VARCHAR(30),
  biography TEXT,
  celebrity_name VARCHAR(50) NOT NULL DEFAULT '',
  celebrity_type TINYINT,
  id INT AUTO_INCREMENT,
  profile_picture INT,
  PRIMARY KEY (id),
  FOREIGN KEY(profile_picture) REFERENCES Media(id)
);

CREATE Table CelebrityMedia(
  celebrity_id INT,
  media_id INT,
  PRIMARY KEY (celebrity_id, media_id),
  FOREIGN KEY (celebrity_id) REFERENCES Celebrities(id),
  FOREIGN KEY (media_id) REFERENCES Media(id)
);

CREATE TABLE ContentMetadata(
  audience_score REAL(5,2) NOT NULL DEFAULT -1,
  content_name VARCHAR(200),
  id INT AUTO_INCREMENT,
  mango_score REAL(5,2) NOT NULL DEFAULT -1,
  maturity_rating VARCHAR(15),
  release_date DATE,
  runtime INTEGER,
  studio_network VARCHAR(100),
  summary TEXT,
  PRIMARY KEY (id)
);

CREATE TABLE Content(
  content_type TINYINT,
  id INT AUTO_INCREMENT,
  metadata_id INT,
  summary_photo INT,
  PRIMARY KEY(id),
  FOREIGN KEY(metadata_id) REFERENCES ContentMetaData(id),
  FOREIGN KEY(summary_photo) REFERENCES Media(id)
);

CREATE Table ContentMedia(
  content_id INT,
  media_id INT,
  PRIMARY KEY (content_id, media_id),
  FOREIGN KEY (content_id) REFERENCES Content(id),
  FOREIGN KEY (media_id) REFERENCES Media(id)
);

CREATE TABLE Ratings(
  body TEXT,
  content_id INT,
  id INT AUTO_INCREMENT,
  score TINYINT,
  user_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY(content_id) REFERENCES ContentMetaData(id),
  FOREIGN KEY(user_id) REFERENCES Users(id)
);

CREATE TABLE Interests(
  content_id INT,
  user_id INT,
  PRIMARY KEY(user_id, content_id),
  FOREIGN KEY(user_id) REFERENCES Users(id),
  FOREIGN KEY(content_id) REFERENCES Content(id)
);

CREATE TABLE Disinterests(
  content_id INT,
  user_id INT,
  PRIMARY KEY(user_id, content_id),
  FOREIGN KEY(user_id) REFERENCES Users(id),
  FOREIGN KEY(content_id) REFERENCES Content(id)
);

CREATE TABLE Casted(
  celebrity_id INT,
  character_name VARCHAR (256),
  content_id INT,
  PRIMARY KEY(celebrity_id, content_id),
  FOREIGN KEY(celebrity_id) REFERENCES Celebrities(id),
  FOREIGN KEY(content_id) REFERENCES Content(id)
);

CREATE TABLE Season(
  season_id INT,
  show_id INT,
  PRIMARY KEY(show_id, season_id),
  FOREIGN KEY(show_id) REFERENCES Content(id),
  FOREIGN KEY(season_id) REFERENCES Content(id)
);

CREATE TABLE Episode(
  episode_id INT,
  season_id INT,
  PRIMARY KEY(season_id, episode_id),
  FOREIGN KEY(season_id) REFERENCES Content(id),
  FOREIGN KEY(episode_id) REFERENCES Content(id)
);
