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

  <div class="details">

    <div>
      <img src="/spas.fe/assets/user.png" width="100" height="100">
    </div>
    <div>
      <%
      	ArrayList<ExamResult> examResults = null;
      if (request.getAttribute("examResults") != null) {
        examResults = (ArrayList<ExamResult>) request.getAttribute("examResults");

       	out.println("<div>" + examResults.get(0).getStudent().getStudentName() + "</div>"); 
       	out.println("<div>" + examResults.get(0).getStudent().getRegisterNumber() + "</div>"); 
       	int endYear = examResults.get(0).getStudent().getBatch().getBatchStartYear() + 4; 
        out.println("<div>" + examResults.get(0).getStudent().getBatch().getBatchStartYear() + "-" + endYear);
        out.println("</div>"); 
       	out.println("<div>" + examResults.get(0).getStudent().getDepartment().getAbbreviation() + "</div>"); 
       }
       %>
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
	if (examResults != null) {
    for(int i=0;i < examResults.size();i++) {
      out.println("<tr>");
      out.println("<td>" + examResults.get(i).getExam().getSemester().getSemesterNumber() + "</td>");
      out.println("<td>" + "Unit Test - 1" + "</td>");
      out.println("<td>" + examResults.get(i).getExam().getSubject().getSubjectCode() + "</td>");
      out.println("<td>" + examResults.get(i).getExam().getSubject().getSubjectName() + "</td>");
      out.println("<td>" + "Marks:" + examResults.get(i).getMarks() + "</td>" + "<br>");
      out.println("</tr>");
    }
	}

   %>
  </table>

<div class="centered-container">
	<div id="curve_chart" style="width: 550px; height: 400px; text-align: center"></div>
</div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  
  <%

    
  out.print("var data = google.visualization.arrayToDataTable([" + 
    "['Test', 'Second year','Third year','Final year']" + 
    ",['UT-1', 50, 80 , 90]," + 
    "['IA-1', 70, 60 ,80]," + 
    "['UT-2', 75, 65 ,70]," + 
    "['IA-2', 70, 70 ,70]," + 
    "['Model', 80, 75 ,75]," + 
    "['Final Exam',60 ,75 ,80]]);");
  
  %>

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Pass Percentage', 'width':550, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
  chart.draw(data, options);
}
</script>

</body>

</html>