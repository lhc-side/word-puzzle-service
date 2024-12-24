insert into word (id, word, description, active, created_by, updated_by)
values (1, '김상은', '캥거루족', 1, 'system', 'system'),
       (2, '김성산', '치치주인', 1, 'system', 'system'),
       (3, '이슬기', '자몽언니', 1, 'system', 'system');

insert into quiz (id, puzzle_id, word_id, quiz_type, quiz_no, active, created_by, updated_by)
values (1, 1, 1, 'VERTICAL', 1, 1, 'system', 'system'),
       (2, 1, 2, 'VERTICAL', 2, 1, 'system', 'system'),
       (3, 1, 3, 'HORIZONTAL', 1, 1, 'system', 'system');

insert into puzzle (id, template_id, active, created_by, updated_by)
values (1, 1, 1, 'system', 'system');

insert into puzzle_template (id, contents, active, created_by, updated_by)
values (1, '[[0,0,1,1,0],[1,1,1,0,1],[0,1,0,0,1],[0,1,0,0,0],[0,1,1,1,0]]', 1, 'system', 'system');

