package com.joelkingsley.rmkcet.spas.be.constants;

public class DBQueries {

	public static final String GET_ALL_DEPARTMENTS = 
			"SELECT department_id, \r\n" + 
			"       department_name, \r\n" + 
			"       abbreviation \r\n" + 
			"FROM   departments ";
	public static final String GET_ALL_USER_TYPES = 
			"SELECT user_type_id, \r\n" + 
			"       NAME \r\n" + 
			"FROM   user_types ";
	public static final String GET_ALL_USERS = 
			"SELECT users.user_id, \r\n" + 
			"       users.NAME, \r\n" + 
			"       users.email, \r\n" + 
			"       users.password, \r\n" + 
			"       user_types.user_type_id, \r\n" + 
			"       user_types.NAME, \r\n" + 
			"       departments.department_id, \r\n" + 
			"       departments.department_name, \r\n" + 
			"       departments.abbreviation \r\n" + 
			"FROM   users \r\n" + 
			"       LEFT JOIN user_types \r\n" + 
			"              ON ( users.fk_user_types_user_type_id = user_types.user_type_id ) \r\n" + 
			"       LEFT JOIN departments \r\n" + 
			"              ON ( users.fk_departments_department_id = \r\n" + 
			"                   departments.department_id ) ";
	public static final String GET_ALL_SUBJECTS = 
			"SELECT subject_id, \r\n" + 
			"       subject_code, \r\n" + 
			"       subject_name, \r\n" + 
			"       credit \r\n" + 
			"FROM   subjects ";
	public static final String GET_ALL_BATCHES = 
			"SELECT batch_id, \r\n" + 
			"       batch_start_year \r\n" + 
			"FROM   batches ";
	public static final String GET_ALL_SEMESTERS = 
			"SELECT semesters.semester_id, \r\n" + 
			"       semesters.semester_number, \r\n" + 
			"       batches.batch_id, \r\n" + 
			"       batches.batch_start_year, \r\n" + 
			"       departments.department_id, \r\n" + 
			"       departments.department_name, \r\n" + 
			"       departments.abbreviation \r\n" + 
			"FROM   semesters \r\n" + 
			"       LEFT JOIN batches \r\n" + 
			"              ON ( semesters.fk_batches_batch_id = batches.batch_id ) \r\n" + 
			"       LEFT JOIN departments \r\n" + 
			"              ON ( semesters.fk_departments_department_id = \r\n" + 
			"                   departments.department_id ) ";
	public static final String GET_ALL_STUDENTS = 
			"SELECT students.student_id, \r\n" + 
			"       students.register_number, \r\n" + 
			"       students.student_name, \r\n" + 
			"       students.gender, \r\n" + 
			"       students.is_hosteler, \r\n" + 
			"       batches.batch_id, \r\n" + 
			"       batches.batch_start_year, \r\n" + 
			"       departments.department_id, \r\n" + 
			"       departments.department_name, \r\n" + 
			"       departments.abbreviation \r\n" + 
			"FROM   students \r\n" + 
			"       LEFT JOIN batches \r\n" + 
			"              ON ( students.fk_batches_batch_id = batches.batch_id ) \r\n" + 
			"       LEFT JOIN departments \r\n" + 
			"              ON ( students.fk_departments_department_id = \r\n" + 
			"                   departments.department_id ) "; 
	public static final String GET_ALL_EXAM_TYPES = "SELECT exam_type_id, \r\n" + 
			"       exam_type_name, \r\n" + 
			"       abbreviation \r\n" + 
			"FROM   exam_types ";
	public static final String GET_ALL_EXAM_RESULTS = 
			"SELECT exam_results.exam_result_id, \r\n" + 
			"       exam_results.marks, \r\n" + 
			"       exam_results.grade, \r\n" + 
			"       exams.exam_id, \r\n" + 
			"       exam_types.exam_type_id, \r\n" + 
			"       exam_types.exam_type_name, \r\n" + 
			"       exam_types.abbreviation, \r\n" + 
			"       subjects.subject_id, \r\n" + 
			"       subjects.subject_code, \r\n" + 
			"       subjects.subject_name, \r\n" + 
			"       subjects.credit, \r\n" + 
			"       semesters.semester_id, \r\n" + 
			"       semesters.semester_number, \r\n" + 
			"       batches.batch_id, \r\n" + 
			"       batches.batch_start_year, \r\n" + 
			"       departments.department_id, \r\n" + 
			"       departments.department_name, \r\n" + 
			"       departments.abbreviation, \r\n" + 
			"       students.student_id, \r\n" + 
			"       students.register_number, \r\n" + 
			"       students.student_name, \r\n" + 
			"       students.gender, \r\n" + 
			"       students.is_hosteler \r\n" + 
			"FROM   exam_results \r\n" + 
			"       LEFT JOIN exams \r\n" + 
			"              ON ( exam_results.fk_exams_exam_id = exams.exam_id ) \r\n" + 
			"       LEFT JOIN exam_types \r\n" + 
			"              ON ( exams.fk_exam_types_exam_type_id = exam_types.exam_type_id ) \r\n" + 
			"       LEFT JOIN subjects \r\n" + 
			"              ON ( exams.fk_subjects_subject_id = subjects.subject_id ) \r\n" + 
			"       LEFT JOIN semesters \r\n" + 
			"              ON ( exams.fk_semesters_semester_id = semesters.semester_id ) \r\n" + 
			"       LEFT JOIN batches \r\n" + 
			"              ON ( semesters.fk_batches_batch_id = batches.batch_id ) \r\n" + 
			"       LEFT JOIN departments \r\n" + 
			"              ON ( semesters.fk_departments_department_id = \r\n" + 
			"                   departments.department_id ) \r\n" + 
			"       LEFT JOIN students \r\n" + 
			"              ON ( exam_results.fk_students_student_id = students.student_id ) "; 
	public static final String GET_ALL_EXAMS = "SELECT exam_id, exam_types.exam_type_id, exam_types.exam_type_name, exam_types.abbreviation, subjects.subject_id, subjects.subject_code, subjects.subject_name, subjects.credit, semesters.semester_id, semesters.semester_number, semesters.fk_batches_batch_id, semesters.fk_departments_department_id, batches.batch_id, batches.batch_start_year, departments.department_id, departments.department_name, departments.abbreviation FROM exams LEFT JOIN exam_types ON (exam_types.exam_type_id = exams.fk_exam_types_exam_type_id) LEFT JOIN subjects ON (subjects.subject_id = exams.fk_subjects_subject_id) LEFT JOIN semesters ON (semesters.semester_id = exams.fk_semesters_semester_id) LEFT JOIN batches ON (batches.batch_id = semesters.fk_batches_batch_id) LEFT JOIN departments ON (departments.department_id = semesters.fk_departments_department_id) ";
	public static final String GET_ALL_EXAM_RESULTS_OF_REGISTER_NUMBER = 
			"SELECT exam_results.exam_result_id, \r\n" + 
			"       exam_results.marks, \r\n" + 
			"       exam_results.grade, \r\n" + 
			"       exams.exam_id, \r\n" + 
			"       exam_types.exam_type_id, \r\n" + 
			"       exam_types.exam_type_name, \r\n" + 
			"       exam_types.abbreviation, \r\n" + 
			"       subjects.subject_id, \r\n" + 
			"       subjects.subject_code, \r\n" + 
			"       subjects.subject_name, \r\n" + 
			"       subjects.credit, \r\n" + 
			"       semesters.semester_id, \r\n" + 
			"       semesters.semester_number, \r\n" + 
			"       batches.batch_id, \r\n" + 
			"       batches.batch_start_year, \r\n" + 
			"       departments.department_id, \r\n" + 
			"       departments.department_name, \r\n" + 
			"       departments.abbreviation, \r\n" + 
			"       students.student_id, \r\n" + 
			"       students.register_number, \r\n" + 
			"       students.student_name, \r\n" + 
			"       students.gender, \r\n" + 
			"       students.is_hosteler \r\n" + 
			"FROM   exam_results \r\n" + 
			"       LEFT JOIN exams \r\n" + 
			"              ON ( exam_results.fk_exams_exam_id = exams.exam_id ) \r\n" + 
			"       LEFT JOIN exam_types \r\n" + 
			"              ON ( exams.fk_exam_types_exam_type_id = exam_types.exam_type_id ) \r\n" + 
			"       LEFT JOIN subjects \r\n" + 
			"              ON ( exams.fk_subjects_subject_id = subjects.subject_id ) \r\n" + 
			"       LEFT JOIN semesters \r\n" + 
			"              ON ( exams.fk_semesters_semester_id = semesters.semester_id ) \r\n" + 
			"       LEFT JOIN batches \r\n" + 
			"              ON ( semesters.fk_batches_batch_id = batches.batch_id ) \r\n" + 
			"       LEFT JOIN departments \r\n" + 
			"              ON ( semesters.fk_departments_department_id = \r\n" + 
			"                   departments.department_id ) \r\n" + 
			"       LEFT JOIN students \r\n" + 
			"              ON ( exam_results.fk_students_student_id = students.student_id ) " +
			"WHERE  students.register_number = ?";
	public static final String ADD_BATCH = "INSERT INTO batches(batch_start_year) VALUES(?)"; 
	
	public static final String GET_SUBJECT = "SELECT subject_id, subject_code, subject_name, credit FROM subjects where subject_code LIKE ?";
	public static final String ADD_EXAM = "INSERT INTO exams(fk_exam_types_exam_type_id,fk_subjects_subject_id,fk_semesters_semester_id) VALUES(?,?,?)";
	public static final String ADD_EXAMTYPE = "INSERT INTO examTypes(exam_Type_name, abbreviation) values(?,?)";
	public static final String ADD_STUDENT = "INSERT INTO students(student_id, register_number, student_name, gender, is_hosteler, fk_batches_batch_id, fk_departments_department_id) values(?,?,?,?,?,?,?) ";
	public static final String ADD_SUBJECT = "INSERT INTO subjects(subject_code, subject_name, credit) values(?,?,?)";
	public static final String ADD_SEMESTER = "INSERT INTO semesters(semester_number, fk_batches_batch_id, fk_departments_department_id) values(?,?,?)";

}
