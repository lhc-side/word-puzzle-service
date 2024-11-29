create table word
(
    id          bigint auto_increment primary key,
    word        varchar(50)   not null comment '낱말',
    description varchar(1000) not null comment '낱말설명',
    active      tinyint(1)      not null default true comment '데이터 활성화 여부',
    created_by  varchar(100)  not null comment '생성자',
    created_at  timestamp     not null default now() comment '생성시간',
    updated_by  varchar(100)  not null comment '수정자',
    updated_at  timestamp     not null default now() comment '수정시간'
);

create table quiz
(
    id         bigint auto_increment primary key,
    puzzle_id  bigint       not null comment '퍼즐id',
    word_id    bigint       not null comment '낱말id',
    quiz_type  varchar(20)  not null comment '퀴즈 타입(가로:V, 세로:H)',
    quiz_no    int          not null comment '퀴즈 번호',
    active     tinyint(1)      not null default true comment '데이터 활성화 여부',
    created_by varchar(100) not null comment '생성자',
    created_at timestamp    not null default now() comment '생성시간',
    updated_by varchar(100) not null comment '수정자',
    updated_at timestamp    not null default now() comment '수정시간'
);

create table puzzle
(
    id          bigint auto_increment primary key,
    template_id bigint       not null comment '템플릿id',
    active      tinyint(1)      not null default true comment '데이터 활성화 여부',
    created_by  varchar(100) not null comment '생성자',
    created_at  timestamp    not null default now() comment '생성시간',
    updated_by  varchar(100) not null comment '수정자',
    updated_at  timestamp    not null default now() comment '수정시간'
);

create table puzzle_templates
(
    id         bigint auto_increment primary key,
    contents   text         not null comment '템플릿',
    active     tinyint(1)      not null default true comment '데이터 활성화 여부',
    created_by varchar(100) not null comment '생성자',
    created_at timestamp    not null default now() comment '생성시간',
    updated_by varchar(100) not null comment '수정자',
    updated_at timestamp    not null default now() comment '수정시간'
);

create table puzzle_submission
(
    id         bigint auto_increment primary key,
    puzzle_id  bigint       not null comment '퍼즐id',
    contents   text         not null comment '제출',
    active     tinyint(1)      not null default true comment '데이터 활성화 여부',
    created_by varchar(100) not null comment '생성자',
    created_at timestamp    not null default now() comment '생성시간',
    updated_by varchar(100) not null comment '수정자',
    updated_at timestamp    not null default now() comment '수정시간'
);

