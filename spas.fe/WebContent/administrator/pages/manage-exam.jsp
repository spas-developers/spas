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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="/spas.fe/general/css/header.css">
    <link rel="stylesheet" href="/spas.fe/general/css/navbar.css">
    <link rel="stylesheet" href="/spas.fe/general/css/dashboard.css">
    <link rel="stylesheet" href="/spas.fe/general/css/fonts.css">
    <link rel="stylesheet" href="/spas.fe/administrator/css/administrator.css">

</head>

<body>
    <header>
        <div id="ztech-logo">
            <img src="/spas.fe/assets/spas.png">
        </div>
    </header>
    <section class="navbar">
        <div class="courier bold">
            <a href="" class="menu-button">Dashboard</a>
            <div class="dropdown-content dashboard-drop">
                <a href="/spas.fe/studentDashboard">Students</a>
                <a href="/spas.fe/examDashboard">Exams</a>
                <a href="/spas.fe/examResultDashboard">Exam Results</a>
            </div>
        </div>
        <div class="courier bold">
            <a href="" class="active menu-button">Manage</a>
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
        <table class="list-table">
            <tr>
                <th>Exam ID</th>
                <th>Exam Type</th>
                <th>Subject Code</th>
                <th>Subject Name</th>
                <th>Batch</th>
                <th>Department</th>
            </tr>
            <% 
                    if (request.getAttribute("exams") != null) {
                        ArrayList<Exam> exams = (ArrayList<Exam>) request.getAttribute("exams");
                                for (int i=0;i < exams.size();i++) {
                                    int batchStartYear = exams.get(i).getSemester().getBatch().getBatchStartYear();
                                    int batchEndYear = batchStartYear + 4;
                                    out.println("<tr>");
                                    out.println("<td>" + exams.get(i).getExamID() + "</td>");
                                    out.println("<td>" + exams.get(i).getExamType().getExamTypeName() + "</td>");
                                    out.println("<td>" + exams.get(i).getSubject().getSubjectCode() + "</td>");
                                    out.println("<td>" + exams.get(i).getSubject().getSubjectName() + "</td>");
                                    out.println("<td>" + batchStartYear + "-" + batchEndYear + "</td>");
                                    out.println("<td>" + exams.get(i).getSemester().getDepartment().getAbbreviation() + "</td>");
                                    out.println("</tr>");
                                }
                    }
                    %>
        </table>
        <div class="w3-container">
            <button onclick="document.getElementById('id01').style.display='block'"
                class="w3-button w3-black add-button">Add
                Exam</button>

            <div id="id01" class="w3-modal">
                <div class="w3-modal-content">
                    <div class="w3-container">
                        <span onclick="document.getElementById('id01').style.display='none'"
                            class="w3-button w3-display-topright">&times;</span>
                        <form class="centered" action="manageExam" method="POST">
                            <table>
                                <div class="body-title open-sans-condensed">
                                    Add Exam
                                </div>
                                <table class="form-table">
                                    <tr>
                                        <td><span>Exam Type: </span></td>
                                        <td><select name="examType">
                                                <% 
                                                    ArrayList<ExamType> examTypes = (ArrayList<ExamType>) request.getAttribute("examTypes");
                                                    for(int i=0 ; i < examTypes.size() ; i++) {
                                                        out.print("<option>");
                                                        out.print(examTypes.get(i).getExamTypeID() + ":" + examTypes.get(i).getExamTypeName());
                                                        out.print("</option>");
                                                    }
                                                %>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td><span>Subject: </span></td>
                                        <td><select name="subject">
                                                <% 
                                                    if (request.getAttribute("subjects") != null) {
                                                        ArrayList<Subject> subjects = (ArrayList<Subject>) request.getAttribute("subjects");
                                                        for(int i=0 ; i < subjects.size() ; i++) {
                                                            out.print("<option>");
                                                            out.print(subjects.get(i).getSubjectID() + ":" + subjects.get(i).getSubjectName());
                                                            out.print("</option>");
                                                        }
                                                    }
                                                %>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td><span>Semester: </span></td>
                                        <td><select name="semester">
                                                <% 
                                                    ArrayList<Semester> semesters = (ArrayList<Semester>) request.getAttribute("semesters");
                                                    for(int i=0 ; i < semesters.size() ; i++) {
                                                        out.print("<option>");
                                                        out.print(semesters.get(i).getSemesterID() + ":" + semesters.get(i).getSemesterNumber());
                                                        out.print("</option>");
                                                    }
                                                %>
                                            </select></td>
                                    </tr>
                                </table>
                                <div class="centered">
                                    <button class="w3-button w3-black add-button" name="addExamButton">Add Exam
                                    </button>
                                </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

</body>

</html>