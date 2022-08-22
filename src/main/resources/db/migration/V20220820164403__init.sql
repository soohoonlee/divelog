CREATE TABLE dive_resort
(
    id                      BIGINT AUTO_INCREMENT NOT NULL,
    name                    VARCHAR(255)          NULL,
    owner_name              VARCHAR(255)          NULL,
    contact_number          VARCHAR(255)          NULL,
    address                 VARCHAR(255)          NULL,
    `description`           VARCHAR(255)          NULL,
    created_date_time       DATETIME(6)           NULL,
    last_modified_date_time DATETIME(6)           NULL,
    PRIMARY KEY (id)
) engine = InnoDB;

CREATE TABLE dive_point
(
    id                      BIGINT AUTO_INCREMENT NOT NULL,
    dive_resort_id          BIGINT                NULL,
    name                    VARCHAR(255)          NULL,
    depth                   VARCHAR(255)          NULL,
    `description`           VARCHAR(255)          NULL,
    created_date_time       DATETIME(6)           NULL,
    last_modified_date_time DATETIME(6)           NULL,
    PRIMARY KEY (id)
) engine = InnoDB;

CREATE TABLE dive_log
(
    id                      BIGINT AUTO_INCREMENT NOT NULL,
    dive_point_id           BIGINT                NULL,
    dive_date               date                  NULL,
    entry_time              time                  NULL,
    exit_time               time                  NULL,
    weather                 VARCHAR(255)          NULL,
    buddy_name              VARCHAR(255)          NULL,
    note                    VARCHAR(255)          NULL,
    created_date_time       DATETIME(6)           NULL,
    last_modified_date_time DATETIME(6)           NULL,
    PRIMARY KEY (id)
) engine = InnoDB;
