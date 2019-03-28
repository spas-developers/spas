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
            <a href="" class="active menu-button">Dashboard</a>
            <div class="dropdown-content dashboard-drop">
                <a href="">Students</a>
                <a href="">Exams</a>
                <a href="">Exam Results</a>
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

        <table class="list-table">
            <tr>
                <th>Semester ID</th>
                <th>Semester Number</th>
                <th>Batch</th>
                <th>Department</th>
            </tr>
            <% 
                        ArrayList<Semester> semesters = (ArrayList<Semester>) request.getAttribute("semesters");
                            for (int i=0;i < semesters.size();i++) {
                                out.println("<tr>");
                                out.println("<td>" + semesters.get(i).getSemesterID() + "</td>");
                                out.println("<td>" + semesters.get(i).getSemesterNumber() + "</td>");
                                out.println("<td>" + semesters.get(i).getBatch().getBatchStartYear() + "</td>");
                                out.println("<td>" + semesters.get(i).getDepartment().getAbbreviation() + "</td>");
                                out.println("</tr>");
                            }
                    %>
        </table>

        <div class="w3-container">
            <button onclick="document.getElementById('id01').style.display='block'"
                class="w3-button w3-black add-button">Add
                Semester</button>

            <div id="id01" class="w3-modal">
                <div class="w3-modal-content">
                    <div class="w3-container">
                        <span onclick="document.getElementById('id01').style.display='none'"
                            class="w3-button w3-display-topright">&times;</span>
                        <form class="centered">
                            <table>
                                <div class="body-title open-sans-condensed">
                                    Add Semester
                                </div>
                                <table class="form-table">
                                    <tr>
                                        <td>
                                            <span> Semester Number: </span>
                                        </td>
                                        <td>
                                            <input type="number">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span>Batch: </span></td>
                                        <td><select>
                                                <% 
                                                ArrayList<Batch> batches = (ArrayList<Batch>) request.getAttribute("batches");
                                                for(int i=0 ; i < batches.size() ; i++) {
                                                    out.print("<option>");
                                                    out.print(batches.get(i).getBatchID() + ":" + batches.get(i).getBatchStartYear());
                                                    out.print("</option>");
                                                }
                                            %>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td> <span>Department:</span></td>
                                        <td><select>
                                                <% 
                                                ArrayList<Department> departments = (ArrayList<Department>) request.getAttribute("departments");
                                                for(int i=0 ; i < departments.size() ; i++) {
                                                    out.print("<option>");
                                                    out.print(departments.get(i).getDepartmentID() + ":" + departments.get(i).getAbbreviation());
                                                    out.print("</option>");
                                                }
                                            %>
                                            </select></td>
                                    </tr>
                                </table>
                                <div class="centered">
                                    <button class="w3-button w3-black add-button">Add Semester</button>
                                </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

</body>

</html>