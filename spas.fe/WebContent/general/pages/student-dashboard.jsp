<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.ExamResult"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Exam"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Student"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Batch"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Department"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.ExamType"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Subject"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Semester"%>

<html>

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/spas.fe/general/css/header.css">
    <link rel="stylesheet" href="/spas.fe/general/css/navbar.css">
    <link rel="stylesheet" href="/spas.fe/general/css/dashboard.css">
    <link rel="stylesheet" href="/spas.fe/general/css/fonts.css">
    <link rel="stylesheet" href="/spas.fe/general/css/student-dashboard.css">
    <link rel="stylesheet" href="/spas.fe/administrator/css/administrator.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>

<body>
    <header>
        <div id="ztech-logo">
            <img src="/spas.fe/assets/spas.png">
        </div>
    </header>
    <section class="navbar">
        <div class="courier bold">
            <a href="" class="active menu-button">Dashboard</a>
            <div class="dropdown-content dashboard-drop">
                <a href="/spas.fe/studentDashboard">Students</a>
                <a href="/spas.fe/examDashboard">Exams</a>
                <a href="/spas.fe/examResultDashboard">Exam Results</a>
            </div>
        </div>
        <div class="courier bold">
            <a href="" class="menu-button">Manage</a>
            <div class="dropdown-content lt-drop">
                <a href="/spas.fe/manageBatch">Batch</a>
                <a href="/spas.fe/manageDepartment">Department</a>
                <a href="/spas.fe/manageSubject">Subject</a>
                <a href="/spas.fe/manageStudent">Student</a>
                <a href="/spas.fe/manageSemester">Semester</a>
                <a href="/spas.fe/manageExamType">Exam Type</a>
                <a href="/spas.fe/manageExam">Exam</a>
                <a href="/spas.fe/manageExamResult">Exam Result</a>
            </div>
        </div>
        <div class="courier bold">
            <a href="" class="menu-button">Users</a>
            <div class="dropdown-content gt-drop">
                <a href="/spas.fe/manageUser">Manage User</a>
            </div>
        </div>
    </section>
    <section class="courier">
        <div class="body-title">STUDENT</div>
        <form class="search" action="studentDetail" method="POST">
            <input type="text" placeholder="Search.." name="search-value">
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>
        <table class="student-table">
            <tr>
                <th>Photo</th>
                <th>Register</th>
                <th>Student Name</th>
                <th>Gender</th>
                <th>Hosteler/Dayscholar</th>
                <th>Batch</th>
                <th>Department</th>
            </tr>
            <%
            	if (request.getAttribute("students") != null) {
                                            ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
                                                    for(int i=0; i < students.size(); i++) {
                                                        String hd = "Day Scholar";
                                                        if(students.get(i).getIsHosteler()) {
                                                            hd = "Hosteler";
                                                        }
                                                        out.println("<tr>");
                                                        out.println("<td>" + "<img src=\"/spas.fe/assets/user.png\" style=\"width: 110px; height: 120px;\">" + "</td>");
                                                        out.println("<td>" + students.get(i).getRegisterNumber() + "</td>");
                                                        out.println("<td>" + students.get(i).getStudentName() + "</td>");
                                                        out.println("<td>" + students.get(i).getGender() + "</td>");
                                                        out.println("<td>" + hd + "</td>");
                                                        out.println("<td>" + students.get(i).getBatch().getBatchStartYear() + "</td>");
                                                        out.println("<td>" + students.get(i).getDepartment().getAbbreviation() + "</td>");
                                                        out.println("</tr>");
                                                    }
                                        }
            %>
        </table>
    </section>
</body>

</html>