<%-- 
    Document   : index
    Created on : Feb 17, 2012, 12:15:46 PM
    Author     : anubrata
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Add Photo</h2>
        <form id="form1" enctype="multipart/form-data" action="AddPhotoServlet" method="POST">
            <table>
                <tr>
                    <td>Enter Photo Id :</td>
                    <td><input  type="text"  name="id"/></td>
                </tr>
                <tr>
                    <td>Enter Title For Photo :</td>
                    <td><input  type="text"  name="title"/></td>
                </tr>
                <tr>
                    <td>Select Photo  </td>
                    <td><input type="file" name="photo"/>
                </tr>
            </table>
            <p/>
            <input type="submit" value="Add Photo"/>
            
        </form>
        <p/>
        <a href="ListPhotoServlet">List Photos </a>
    </body>
</html>