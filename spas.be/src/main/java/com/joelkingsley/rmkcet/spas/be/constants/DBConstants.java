package com.joelkingsley.rmkcet.spas.be.constants;

public class DBConstants {
	public static final String DRIVER_URL = "jdbc:mysql://localhost:3306/rmkcet_db?autoReconnect=true&useSSL=false";
	public static final String DRIVER_USERNAME = "root";
	public static final String DRIVER_PASSWORD = "joel123R";
	
	public static final String TABLE_DEPARTMENTS = "departments";
	public static final String COL_DEPARTMENTS_DEPARTMENT_ID = "department_id";
	public static final String COL_DEPARTMENTS_DEPARTMENT_NAME = "department_name";
	public static final String COL_DEPARTMENTS_ABBREVIATION = "abbreviation";
	
	public static final String TABLE_USER_TYPES = "user_types";
	public static final String COL_USER_TYPES_USER_TYPE_ID = "user_type_id";
	public static final String COL_USER_TYPES_NAME = "name";
	
	public static final String TABLE_USERS = "users";
	public static final String COL_USERS_USER_ID = "user_id";
	public static final String COL_USERS_NAME = "name";
	public static final String COL_USERS_EMAIL = "email";
	public static final String COL_USERS_PASSWORD = "password";
	public static final String COL_USERS_DEPARTMENT_ID = "fk_departments_department_id";
	public static final String COL_USERS_USER_TYPE_ID = "fk_user_types_user_type_id";
	
	public static final String TABLE_SUBJECTS = "subjects";
	public static final String COL_SUBJECTS_SUBJECT_ID = "subject_id";
	public static final String COL_SUBJECTS_SUBJECT_CODE = "subject_code";
	public static final String COL_SUBJECTS_SUBJECT_NAME = "subject_name";
	public static final String COL_SUBJECTS_CREDIT = "credit";

	public static final String TABLE_BATCHES = "batches";
	public static final String COL_BATCHES_BATCH_ID = "batch_id";
	public static final String COL_BATCHES_BATCH_START_YEAR = "batch_start_year";
	
	public static final Object TABLE_STUDENTS = "students";
	public static final Object COL_STUDENTS_STUDENT_ID = "student_id";
	public static final Object COL_STUDENTS_REGISTER_NUMBER = "register_number";
	public static final Object COL_STUDENTS_STUDENT_NAME = "student_name";
	public static final Object COL_STUDENTS_GENDER = "gender";
	public static final Object COL_STUDENTS_IS_HOSTELER = "is_hosteler";
	
	public static final Object TABLE_SEMESTERS = "semesters";
	public static final String COL_SEMESTERS_SEMESTER_ID = "semester_id";
	public static final String COL_SEMESTERS_SEMESTER_NUMBER = "semester_number";
	
	public static final Object TABLE_EXAM_TYPE = "exam_types";
	public static final String COL_EXAM_TYPES_EXAM_TYPE_ID = "exam_type_id";
	public static final String COL_EXAM_TYPES_EXAM_TYPE_NAME = "exam_type_name";
	public static final String COL_EXAM_TYPES_ABBREVIATION = "abbrevation";
	
	public static final Object TABLE_EXAM_RESULT = "exam_results";
	public static final Object COL_EXAM_RESULTS_EXAM_RESULT_ID = "exam_result_id";
	public static final Object COL_EXAM_RESULTS_MARKS = "marks";
	public static final Object COL_EXAM_RESULTS_GRADE = "grade";
	
}
