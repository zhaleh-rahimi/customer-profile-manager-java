package servlet;

import business_logic.LoanFileLogic;
import business_logic.NaturalCustomerLogic;
import business_logic.exceptions.DataNotFoundException;
import business_logic.exceptions.InputNotInRangeException;
import com.google.gson.JsonObject;
import data_access.LoanFileCRUD;
import data_access.LoanTypeCRUD;
import data_access.entity.LoanFile;
import data_access.entity.LoanType;
import data_access.entity.NaturalCustomer;
import util.LoggerUtil;
import util.MessageUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
@WebServlet(name = "LoanFileServlet", urlPatterns = {"/LoanFileServlet"})
public class LoanFileServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        System.out.println("I can enter in doGet");

        if ("load-loan-file".equalsIgnoreCase(action)) {
            loadLoanFile(request, response);
        }
        if ("retrieve-customer".equalsIgnoreCase(action)) {
            retrieveCustomer(request, response);
        }
        if ("create-loan-file".equalsIgnoreCase(action)) {
            createLoanFile(request, response);
        }
    }

    private void createLoanFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageUtil message = new MessageUtil();
        try {
            LoanFile loanFile = new LoanFile();
            Integer customerId = Integer.parseInt(request.getParameter("customerId"));
            Integer loanTypeId = Integer.parseInt(request.getParameter("loanTypesList"));
            loanFile.setAmount(new BigDecimal(request.getParameter("amount")));
            loanFile.setDuration(Integer.parseInt(request.getParameter("duration")));
            LoanFileLogic.create(customerId, loanTypeId, loanFile);
            MessageUtil.info = "پرونده تسهیلاتی با موفقیت ثبت شد";
            MessageUtil.header = "عملیات موفق";
            request.setAttribute("message", message);
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (InputNotInRangeException e) {
            MessageUtil.info = "مقادیر وارد شده در بازه تعریف شده نیست.";
            MessageUtil.header = "عملیات ناموفق";
            request.setAttribute("error", message);
            LoggerUtil.getLogger().warn("مقادیر ورودی در بازه شروط اعطا صدق نمی کند.");
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (DataNotFoundException e) {
            LoggerUtil.getLogger().warn(e.getMessage());
        }
    }

    private void loadLoanFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = "";
        request.setAttribute("customerId", customerId);
        ArrayList<LoanType> loanTypes = LoanFileLogic.findLoanTypes();
        System.out.println("I can fetch loan types ");
        request.setAttribute("loanTypes", loanTypes);
        System.out.println("I have sent loan types ");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/loan-file.jsp");
        dispatcher.forward(request, response);
    }

    private void retrieveCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        NaturalCustomer naturalCustomer=new NaturalCustomer();
        JsonObject jsonObject = new JsonObject();
        try {
            naturalCustomer = NaturalCustomerLogic.retrieveCustomer(customerId);
            jsonObject.addProperty("firstName", naturalCustomer.getFirstName());
            jsonObject.addProperty("lastName", naturalCustomer.getLastName());
            response.setContentType("application/json");
            response.getWriter().print(jsonObject);
        } catch (DataNotFoundException e) {
            naturalCustomer.setFirstName(null);
            naturalCustomer.setLastName(null);
            jsonObject.addProperty("firstName", naturalCustomer.getFirstName());
            jsonObject.addProperty("lastName", naturalCustomer.getLastName());
            response.setContentType("application/json");
            response.getWriter().print(jsonObject);
        }
    }

}
