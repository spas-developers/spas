CREATE database rmkcet_db;
USE rmkcet_db;

CREATE table users (
	user_id integer auto_increment,
    name varchar(40) not null,
    email varchar(40) unique not null,
    password varchar(40) not null,
    fk_departments_department_id integer not null,
    fk_user_types_user_type_id integer not null,
    PRIMARY KEY (user_id),
    FOREIGN KEY (fk_departments_department_id) references departments(department_id),
    FOREIGN KEY (fk_user_types_user_type_id) references user_types(user_type_id)
);

drop table users;

insert into users(name,email,password,fk_departments_department_id,fk_user_types_user_type_id) values("Joel Kingsley","joelkingsley.r@gmail.com","qwertyjk",1,1);

insert into user_types(name) values("Administrator");

CREATE table user_types (
	user_type_id integer auto_increment,
    name varchar(40) unique not null,
    PRIMARY KEY (user_type_id)
);

CREATE table batches (
	batch_id integer auto_increment,
    batch_start_year integer not null unique,
    PRIMARY KEY (batch_id)
);

insert into batches(batch_start_year) values(2018);

CREATE table departments (
	department_id integer auto_increment,
    department_name varchar(40) not null unique,
    abbreviation varchar(10) not null unique,
    PRIMARY KEY (department_id)
);

insert into departments(department_name,abbreviation) values("Computer Science and Engineering", "CSE");

CREATE table exam_types (
	exam_type_id integer auto_increment,
    exam_type_name varchar(40) not null unique,
    abbreviation varchar(10) not null unique,
    PRIMARY KEY (exam_type_id)
);

insert into exam_types(exam_type_name, abbreviation) values("Final Examination", "FE");

CREATE table subjects (
	subject_id integer auto_increment,
    subject_code varchar(10) not null unique,
    subject_name varchar(40) not null,
    credit integer not null,
    PRIMARY KEY (subject_id)
);

insert into subjects(subject_code,subject_name,credit) values ("MA6451", "Discrete Mathematics",4);

CREATE table semesters (
	semester_id integer auto_increment,
    semester_number integer not null,
    fk_batches_batch_id integer not null,
    fk_departments_department_id integer not null,
    PRIMARY KEY (semester_id),
    FOREIGN KEY (fk_batches_batch_id) references batches(batch_id),
    FOREIGN KEY (fk_departments_department_id) references departments(department_id)
);

insert into semesters(semester_number,fk_batches_batch_id,fk_departments_department_id) values(1,1,1);

CREATE table students (
	student_id integer auto_increment,
    register_number bigint not null unique,
    student_name varchar(40) not null,
    gender varchar(1) not null,
    is_hosteler tinyint(4) not null,
    fk_batches_batch_id integer not null,
    fk_departments_department_id integer not null,
    CHECK (gender="M" OR gender="F"),
    PRIMARY KEY (student_id),
    FOREIGN KEY (fk_batches_batch_id) references batches(batch_id),
    FOREIGN KEY (fk_departments_department_id) references departments(department_id)
);

insert into students(register_number,student_name,gender,is_hosteler,fk_batches_batch_id,fk_departments_department_id) values(111615104069,"Mohammed Ashik","M",0,1,1);

drop table students;

CREATE table exams (
	exam_id integer auto_increment,
    fk_exam_types_exam_type_id integer not null,
    fk_subjects_subject_id integer not null,
    fk_semesters_semester_id integer not null,
    PRIMARY KEY (exam_id),
    FOREIGN KEY (fk_exam_types_exam_type_id) references exam_types(exam_type_id),
    FOREIGN KEY (fk_subjects_subject_id) references subjects(subject_id),
    FOREIGN KEY (fk_semesters_semester_id) references semesters(semester_id)
);

insert into exams(fk_exam_types_exam_type_id,fk_subjects_subject_id,fk_semesters_semester_id) values(1,1,1);

CREATE table exam_results (
	exam_result_id integer auto_increment,
    fk_exams_exam_id integer not null,
    fk_students_student_id integer not null,
    marks integer default 0,
    grade varchar(2) not null,
    PRIMARY KEY (exam_result_id),
    FOREIGN KEY (fk_exams_exam_id) references exams(exam_id),
    FOREIGN KEY (fk_students_student_id) references students(student_id)
);

insert into exam_results(fk_exams_exam_id,fk_students_student_id,marks,grade) values(1,2,92,'S');

drop table exam_results;

show tables;
desc tables;