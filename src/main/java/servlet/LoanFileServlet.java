package servlet;

import business_logic.LoanFileLogic;
import data_access.entity.LoanFile;
import data_access.entity.LoanType;
import data_access.entity.NaturalCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
@WebServlet(name = "LoanFileServlet", urlPatterns = {"/LoanFile"})
public class LoanFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ("retrieve-customer".equalsIgnoreCase(action)) {
            retrieveCustomerById(request, response);
        }
        if ("fetch-loan-types".equalsIgnoreCase(action)) {
            fetchLoanTypes(request, response);
        }
    }

    private void fetchLoanTypes(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<LoanType> loanTypes= LoanFileLogic.findLoanTypes();
    }

    private void retrieveCustomerById(HttpServletRequest request, HttpServletResponse response){
        int id= Integer.parseInt(request.getParameter("customerId"));
        NaturalCustomer naturalCustomer=LoanFileLogic.findCustomerById(id);
        request.setAttribute("naturalCustomer", naturalCustomer);
    }
}
