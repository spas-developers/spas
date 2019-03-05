package com.joelkingsley.rmkcet.spas.be.constants;

public class DBQueries {

	public static final String GET_ALL_DEPARTMENTS = "SELECT department_id, department_name, abbreviation FROM departments";
	public static final String GET_ALL_USER_TYPES = "SELECT user_type_id, name FROM user_types";
	public static final String GET_ALL_USERS = "SELECT users.user_id, users.name, users.email, users.password, user_types.user_type_id, user_types.name, departments.department_id, departments.department_name, departments.abbreviation FROM users LEFT JOIN user_types on (users.fk_user_types_user_type_id = user_types.user_type_id) LEFT JOIN departments on (users.fk_departments_department_id = departments.department_id)";
	public static final String GET_ALL_BATCHES = "SELECT batch_id, batch_start_year FROM batches";
	public static final String GET_ALL_STUDENTS = "SELECT students.student_id, students,register_number, students.students_name, students.gender, students.is_hosteler, batches.batch_id, batches.batch_start_year, departments.department_name, departments.abbreviation FROM students LEFT JOIN batches ON (batches.fk_batches_batch_id = batches.batch_id) LEFT JOIN departments ON (users.fk_departments_department_id = departments.department_id)"; 

}
