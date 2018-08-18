<%-- 
    Document   : Examplejsp
    Created on : Jun 25, 2018, 3:38:45 PM
    Author     : win7
--%>


<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ResultProcess.jsp" method="POST">
            Select Anyone:<select name="drd_roll">
                <%!Connection con;
                PreparedStatement ps;
                %>>
                <%
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url="jdbc:oracle:thin:@localhost:1521:XE";
                con=DriverManager.getConnection(url, "rohan", "rohan");
                String s="Select roll, name from student";
                ps=con.prepareStatement(s);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                %>
                <option value="<%= rs.getInt(1)%>"><%=rs.getString(2)%></option>
                <%} %>
            </select>
        </form>
    </body>
</html>
