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
	
	public static final String COL_BATCHES_BATCH_ID = "batch_id";
	public static final String COL_BATCHES_BATCH_START_YEAR = "batch_start_year";
	public static final Object TABLE_STUDENTS = "students";
	public static final Object COL_STUDENTS_STUDENT_ID = "student_id";
	public static final Object COL_STUDENTS_REGISTER_NUMBER = "register_number";
	public static final Object COL_STUDENTS_STUDENT_NAME = "student_name";
	public static final Object COL_STUDENTS_GENDER = "gender";
	public static final Object COL_STUDENTS_IS_HOSTELER = "is_hosteler";
	public static final Object TABLE_BATCHES = "batches";
	public static final Object COL_BATCH_START_YEAR = "batch_start_year";
	
}
