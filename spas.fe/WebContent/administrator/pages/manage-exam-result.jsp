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
                <th>Exam Result ID</th>
                <th>Exam ID</th>
                <th>Exam Type</th>
                <th>Batch</th>
                <th>Semester</th>
                <th>Student Name</th>
                <th>Register Number</th>
                <th>Marks/Grade</th>
            </tr>
            <% 
            	if (request.getAttribute("examResults") != null){
	                ArrayList<ExamResult> examResults = (ArrayList<ExamResult>) request.getAttribute("examResults");
	                    for (int i=0;i < examResults.size();i++) {
	                        int batchStartYear = examResults.get(i).getExam().getSemester().getBatch().getBatchStartYear();
	                        int batchEndYear = batchStartYear + 4;
	                        out.println("<tr>");
	                        out.println("<td>" + examResults.get(i).getExamResultID() + "</td>");
	                        out.println("<td>" + examResults.get(i).getExam().getExamID() + "</td>");
	                        out.println("<td>" + examResults.get(i).getExam().getExamType().getExamTypeName() + "</td>");
	                        out.println("<td>" + batchStartYear + "-" + batchEndYear + "</td>");
	                        out.println("<td>" + examResults.get(i).getExam().getSemester().getSemesterNumber() + "</td>");
	                        out.println("<td>" + examResults.get(i).getStudent().getStudentName() + "</td>");
	                        out.println("<td>" + examResults.get(i).getStudent().getRegisterNumber() + "</td>");
	                        out.println("<td>" + examResults.get(i).getMarks() + "/" + examResults.get(i).getGrade() + "</td>");
	                        out.println("</tr>");
	                    }
            	}
            %>
        </table>
        <div class="w3-container">
            <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black add-button">Add
                Exam Result</button>

            <div id="id01" class="w3-modal">
                <div class="w3-modal-content">
                    <div class="w3-container">
                        <span onclick="document.getElementById('id01').style.display='none'"
                            class="w3-button w3-display-topright">&times;</span>
                        <form action="manageExamResult" class="centered" method="POST">
                            <table>
                                <div class="body-title open-sans-condensed">
                                    Add Exam Results
                                </div>
                                <table class="form-table">
                                    <tr>
                                        <td><span>Exam:
                                        <td>
                                            <select name="exam">
                                                <% 
                                                    if (request.getAttribute("exams") != null) {
                                                        ArrayList<Exam> exams = (ArrayList<Exam>) request.getAttribute("exams");
                                                        for(int i=0 ; i < exams.size() ; i++) {
                                                            out.print("<option>");
                                                            out.print(exams.get(i).getExamID()+":"+ exams.get(i).getExamType().getExamTypeName());
                                                            out.print("(" + exams.get(i).getSubject().getSubjectCode()+")");
                                                            out.print("("+"Semester "+exams.get(i).getSemester().getSemesterNumber()+")");
                                                            out.print("("+exams.get(i).getSemester().getBatch().getBatchStartYear()+")");
                                                            out.print("("+exams.get(i).getSemester().getDepartment().getAbbreviation()+")");
                                                            out.print("</option>");
                                                        }
                                                    }
                                                 %>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span>Student: </span></td>
                                        <td>
                                            <select name="student">
                                                <% 
                                                    ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
                                                    for(int i=0 ; i < students.size() ; i++) {
                                                        int batchStartYear = students.get(i).getBatch().getBatchStartYear();
                                                        int batchEndYear = batchStartYear + 4;
                                                        out.print("<option>");
                                                        out.print(students.get(i).getStudentID() + ":" + students.get(i).getStudentName());
                                                        out.print("(" + batchStartYear + "-" + batchEndYear + ")");
                                                        out.print("</option>");
                                                    }
                                                 %>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span>Marks: </span></td>
                                        <td><input type="number" name="marks"></td>
                                    </tr>
                                    <tr>
                                        <td> <span>Grade:</span></td>
                                        <td><select name="grade">
                                                <option>S</option>
                                                <option>A</option>
                                                <option>B</option>
                                                <option>C</option>
                                                <option>D</option>
                                                <option>E</option>
                                                <option>U</option>
                                            </select></td>
                                    </tr>
                                </table>
                                <div class="centered">
                                    <button class="w3-button w3-black add-button" name="addExamResultButton">Add Exam Result</button>
                                </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

</body>

</html>