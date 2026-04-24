<%@ page import="java.util.*" %>

<h2>Available Courses</h2>

<%
List<String> courses = (List<String>) request.getAttribute("courses");

if(courses != null){
    for(String c : courses){
%>
    <p>
        <%= c %>
        <form action="register/1" method="post">
            <button type="submit">Register</button>
        </form>
    </p>
<%
    }
}
%>