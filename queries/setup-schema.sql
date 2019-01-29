CREATE database rmkcet_db;
USE rmkcet_db;

CREATE table batches (
	batch_id integer auto_increment,
    batch_start_year integer not null unique,
    PRIMARY KEY (batch_id)
);

CREATE table departments (
	department_id integer auto_increment,
    department_name varchar(40) not null unique,
    abbreviation varchar(10) not null unique,
    PRIMARY KEY (department_id)
);

CREATE table exam_types (
	exam_type_id integer auto_increment,
    exam_type_name varchar(40) not null unique,
    abbreviation varchar(10) not null unique,
    PRIMARY KEY (exam_type_id)
);

CREATE table subjects (
	subject_id integer auto_increment,
    subject_code varchar(10) not null unique,
    subject_name varchar(40) not null,
    credit integer not null,
    PRIMARY KEY (subject_id)
);

CREATE table semesters (
	semester_id integer auto_increment,
    semester_number integer not null,
    fk_batches_batch_id integer not null,
    fk_departments_department_id integer not null,
    PRIMARY KEY (semester_id),
    FOREIGN KEY (fk_batches_batch_id) references batches(batch_id),
    FOREIGN KEY (fk_departments_department_id) references departments(department_id)
);

CREATE table students (
	student_id integer auto_increment,
    register_number bigint not null unique,
    student_name varchar(40) not null,
    gender varchar(1) not null,
    isHosteler tinyint(4) not null,
    fk_batches_batch_id integer not null,
    fk_departments_department_id integer not null,
    CHECK (gender="M" OR gender="F"),
    PRIMARY KEY (student_id),
    FOREIGN KEY (fk_batches_batch_id) references batches(batch_id),
    FOREIGN KEY (fk_departments_department_id) references departments(department_id)
);

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

show tables;