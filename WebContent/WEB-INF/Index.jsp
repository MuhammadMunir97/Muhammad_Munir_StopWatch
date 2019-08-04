<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="TimerController?id=0">start</a>
	<a href="TimerController?id=1">end</a>
	<a href="TimerController?id=2">reset</a>
	
	<table>
	  <tr>
	    <td> Starting time: ${startingTime}</td>
	    <td>current Time : ${TimeCurrently}</td> 
	    <td>running Time : ${runningTime}</td>
	  </tr>
	</table>
	
	<table>
	  <tr>
	    <th>Start Time</th>
	    <th>Stop Time</th> 
	    <th>TimeElapsed</th>
	  </tr>
    <c:forEach items="${time}" var="t">	
  		<tr>
  			<td>${t.getStartTime()}</td> 
  			<td>${t.getEndTime()}</td> 
  			<td>${t.interval()}</td> 
  		</tr>
	</c:forEach>
	</table>
	
	
	
</body>
</html>