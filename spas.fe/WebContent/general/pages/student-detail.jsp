<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.ExamResult"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Student"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Batch"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Department"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.ExamType"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Subject"%>
<%@ page import ="com.joelkingsley.rmkcet.spas.fe.beans.Semester"%>

<html>
<head>
<link rel="stylesheet" href="/spas.fe/general/css/student-search.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
  <form class="search" action="studentDetail" method="POST">
    <input type="text" placeholder="Search.." name="search">
    <button type="submit"><i class="fa fa-search"></i></button>
  </form>
  <div class="details" >
  
    <div>
      <img src="/spas.fe/assets/ashik.jpg"  width="100" height="100">
    </div>
    <div>
        <%
        ArrayList<ExamResult> examResults = (ArrayList<ExamResult>) request.getAttribute("examResults");
       %>
      <div><% out.println(examResults.get(0).getStudent().getStudentName()); %></div>
      <div><% out.println(examResults.get(0).getStudent().getRegisterNumber()); %></div>
      <div><% out.println(examResults.get(0).getStudent().getBatch().getBatchStartYear()); %>-<% out.println(examResults.get(0).getStudent().getBatch().getBatchStartYear() + 4); %></div>
      <div><% out.println(examResults.get(0).getStudent().getDepartment().getAbbreviation()); %></div>
      <div>Day Scholar</div>
    </div>
  </div>
  <hr>

  <table>
    <tr>
      <th>Semester</th>
      <th>Exam Type</th>
      <th>Subject Code</th>
      <th>Subject Name</th>
      <th>Marks</th>
    </tr>
  <%

    for(int i=0;i < examResults.size();i++) {
      out.println("<tr>");
      out.println("<td>" + examResults.get(i).getExam().getSemester().getSemesterNumber() + "</td>");
      out.println("<td>" + "Unit Test - 1" + "</td>");
      out.println("<td>" + examResults.get(i).getExam().getSubject().getSubjectCode() + "</td>");
      out.println("<td>" + examResults.get(i).getExam().getSubject().getSubjectName() + "</td>");
      out.println("<td>" + "Marks:" + examResults.get(i).getMarks() + "</td>" + "<br>");
      out.println("</tr>");
    }

   %>
  </table>


</body>
</html>