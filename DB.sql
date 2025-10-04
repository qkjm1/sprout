DROP DATABASE IF EXISTS `sprout`;
CREATE DATABASE `sprout`;
USE `sprout`;

---

CREATE USER 'sprout'@'localhost' IDENTIFIED BY '2019133008';
GRANT ALL PRIVILEGES ON sprout.* TO 'sprout'@'localhost';
FLUSH PRIVILEGES;

---

-- ① 일기 본문 테이블
CREATE TABLE diary_entry (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,   -- 고유번호
  usr_id BIGINT NOT NULL,                 -- 유저 아이디
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,               -- 다이어리 기입 날짜
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 다이어리 수정 날짜
  title VARCHAR(200) NOT NULL,            -- 제목
  content TEXT,                           -- 내용
  mood VARCHAR(50),                        -- 기분 (문자열)
  weather VARCHAR(50),                 -- 날씨 상태 (clear, cloudy, rain 등)
  temperature_c DECIMAL(4,1)          -- 온도(℃) 예: 23.4
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
