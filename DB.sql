




-- ① 일기 본문 테이블
CREATE TABLE diary_entry (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,   -- 고유번호
  usr_id BIGINT NOT NULL,                 -- 유저 아이디
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,               -- 다이어리 기입 날짜
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 다이어리 수정 날짜
  title VARCHAR(200) NOT NULL,            -- 제목
  content TEXT,                           -- 내용
  mood VARCHAR(50)                        -- 기분 (문자열)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ② 카카오 API 날씨 저장 테이블
CREATE TABLE diary_weather (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,

  diary_id BIGINT NOT NULL,            -- diary_entry.id 와 1:1
  location_name VARCHAR(200),          -- 위치명만 저장 (예: 서울 중구)

  weather VARCHAR(50),                 -- 날씨 상태 (clear, cloudy, rain 등)
  temperature_c DECIMAL(4,1),          -- 온도(℃) 예: 23.4

  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 수집 시각(생성 시점 고정)

  UNIQUE KEY uq_diary (diary_id),
  CONSTRAINT fk_diary_weather_entry
    FOREIGN KEY (diary_id) REFERENCES diary_entry(id)
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;





