package com.joelkingsley.rmkcet.spas.be.constants;

public class DBQueries {

	public static final String GET_ALL_DEPARTMENTS = "SELECT department_id, department_name, abbreviation FROM departments";
	public static final String GET_ALL_USER_TYPES = "SELECT user_type_id, name FROM user_types";
	public static final String GET_ALL_USERS = "SELECT users.user_id, users.name, users.email, users.password, user_types.user_type_id, user_types.name, departments.department_id, departments.department_name, departments.abbreviation FROM users LEFT JOIN user_types on (users.fk_user_types_user_type_id = user_types.user_type_id) LEFT JOIN departments on (users.fk_departments_department_id = departments.department_id)";
	public static final String GET_ALL_SUBJECTS = "SELECT subject_id, subject_code, subject_name, credit FROM subjects";
	public static final String GET_ALL_BATCHES = "SELECT batch_id, batch_start_year FROM batches";

}
