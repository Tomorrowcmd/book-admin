CREATE
DATABASE IF NOT EXISTS `reading_club`
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE
`reading_club`;


CREATE TABLE `books`
(
    `id`         INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    `title`      VARCHAR(255) NOT NULL COMMENT '书名',
    `author`     VARCHAR(100) NOT NULL COMMENT '作者',
    `category`   VARCHAR(50)  NOT NULL COMMENT '分类',
    `intro`      TEXT COMMENT '简介/摘要',
    `tags`       JSON COMMENT '标签数组 (如: ["推理", "人性"])',
    `date`       DATE         NOT NULL COMMENT '发布/阅读日期',
    `read_time`  VARCHAR(20) COMMENT '阅读所需时长 (如: "8 分钟")',
    `cover`      VARCHAR(500) COMMENT '封面图片URL',
    `rating`     TINYINT UNSIGNED DEFAULT 0 COMMENT '评分 (1-5星)',
    `href`       VARCHAR(255) COMMENT '文章链接地址',
    `content`    JSON COMMENT '详细内容段落数组',
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间',
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



CREATE TABLE `monthly_stats`
(
    `id`            INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `stat_month`    VARCHAR(7) NOT NULL UNIQUE COMMENT '统计月份 (格式: 2026-04)',
    `books_count`   INT UNSIGNED DEFAULT 0 COMMENT '已读数量',
    `hours_count`   INT UNSIGNED DEFAULT 0 COMMENT '阅读时长',
    `reviews_count` INT UNSIGNED DEFAULT 0 COMMENT '书评数量',
    `updated_at`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `books`
(`title`, `author`, `category`, `intro`, `tags`, `date`, `read_time`, `cover`, `rating`, `href`, `content`)
VALUES ('《白夜行》：极致守护背后的沉重真相',
        '东野圭吾',
        '文学小说',
        '东野圭吾用层层递进的叙事，把爱、罪与救赎编织成一段漫长又压抑的命运交缠。',
        '[
          "推理小说",
          "社会派",
          "人性"
        ]',
        '2026-04-17',
        '8 分钟',
        'https://your-image-url.com/white-night.jpg',
        5,
        '/reviews/1',
        '[
          "《白夜行》最动人的地方...",
          "桐原亮司与唐泽雪穗...",
          "东野圭吾用极其克制..."
        ]');