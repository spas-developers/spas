package com.joelkingsley.rmkcet.spas.be.constants;

public class DBQueries {

	public static final String GET_ALL_DEPARTMENTS = "SELECT department_id, department_name, abbreviation FROM departments";
	public static final String GET_ALL_USER_TYPES = "SELECT user_type_id, name FROM user_types";
	public static final String GET_ALL_USERS = "SELECT users.user_id, users.name, users.email, users.password, user_types.user_type_id, user_types.name, departments.department_id, departments.department_name, departments.abbreviation FROM users LEFT JOIN user_types on (users.fk_user_types_user_type_id = user_types.user_type_id) LEFT JOIN departments on (users.fk_departments_department_id = departments.department_id)";
	public static final String GET_ALL_SUBJECTS = "SELECT subject_id, subject_code, subject_name, credit FROM subjects";
	public static final String GET_ALL_BATCHES = "SELECT batch_id, batch_start_year FROM batches";
	public static final String GET_ALL_SEMESTERS = "SELECT semesters.semester_id, semesters.semester_number, batches.batch_id, batches.batch_start_year, departments.department_id, departments.department_name, departments.abbreviation FROM semesters LEFT JOIN batches on (semesters.fk_batches_batch_id = batches.batch_id) LEFT JOIN departments on (semesters.fk_departments_department_id = departments.department_id)";
	public static final String GET_ALL_STUDENTS = "SELECT students.student_id, students.register_number, students.student_name, students.gender, students.is_hosteler, batches.batch_id, batches.batch_start_year, departments.department_id, departments.department_name, departments.abbreviation FROM students LEFT JOIN batches ON (students.fk_batches_batch_id = batches.batch_id) LEFT JOIN departments ON (students.fk_departments_department_id = departments.department_id)"; 
	public static final String GET_ALL_EXAM_TYPES = "SELECT exam_type_id, exam_type_name, abbrevation FROM examTypes";
	public static final String GET_ALL_EXAMS = "SELECT exam_id, exam_type_id, subject_id, semester_id FROM exams LEFT JOIN exam_types ON (exam_types.exam_type_id = exams.fk_exam_types_exam_type_id) LEFT JOIN subjects ON (subjects.subject_id = exams.fk_subjects_subject_id) LEFT JOIN semesters ON (semesters.semester_id = exams.fk_semesters_semester_id) LEFT JOIN batches ON (batches.batch_id = semesters.fk_batches_batch_id) LEFT JOIN departments ON (departments.department_id = semesters.fk_departments_department_id) "; 

}
