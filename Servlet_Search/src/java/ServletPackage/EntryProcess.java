/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import static javax.xml.bind.DatatypeConverter.parseString;

/**
 *
 * @author rohan
 */
public class EntryProcess extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try{
            System.out.println("ServletPackage.EntryProcess.processRequest()");
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
           String url="jdbc:oracle:thin:@localhost:1521:XE";
           Connection con= DriverManager.getConnection(url,"rohan", "rohan");
           
           String s="insert into student values(seq_roll.nextval,?,?,?,?)";
           PreparedStatement ps= con.prepareCall(s);
           
           String name= request.getParameter("txt_name");
           ps.setString(1, name);
           String address= request.getParameter("txt_address");
           ps.setString(2, address);
           int age= Integer.parseInt (request.getParameter("txt_age"));
           ps.setInt(3,age);
           int marks= Integer.parseInt (request.getParameter("txt_marks"));
           ps.setInt(4, marks);
           int i=ps.executeUpdate();
           
           if(i>0){
               out.print("<script>alert('Data inserted');</script>");
           }
           else{
               out.print("<script>alert('Data Not inserted');window.location='Search.html';</script>");
           }
        }catch(Exception e){
        out.print(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("ServletPackage.EntryProcess.doGet()before process");
        processRequest(request, response);
         System.out.println("ServletPackage.EntryProcess.doGet()after process");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ServletPackage.EntryProcess.doPost()before process");
        processRequest(request, response);
        System.out.println("ServletPackage.EntryProcess.doPost() after process");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
