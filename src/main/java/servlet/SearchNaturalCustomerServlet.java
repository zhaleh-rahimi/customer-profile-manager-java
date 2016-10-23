package servlet;

import business_logic.NaturalCustomerLogic;
import business_logic.exceptions.DataNotFoundException;
import data_access.entity.NaturalCustomer;
import util.LoggerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by dotinschool3 on 10/3/2016.
 */
@WebServlet(name = "SearchNaturalCustomerServlet", urlPatterns = {"/SearchNaturalCustomer"})
public class SearchNaturalCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        NaturalCustomer naturalCustomer = new NaturalCustomer();
        ArrayList<NaturalCustomer> naturalCustomers = null;
        try {
            if (request.getParameter("customerId").equals("")) {
                naturalCustomer.setCustomerId(null);
            } else {
                naturalCustomer.setCustomerId(Integer.valueOf(request.getParameter("customerId")));
            }
            if (request.getParameter("firstName").equals("")) {
                naturalCustomer.setFirstName(null);
            } else {
                naturalCustomer.setFirstName(request.getParameter("firstName"));
            }
            if (request.getParameter("lastName").equals("")) {
                naturalCustomer.setLastName(null);
            } else {
                naturalCustomer.setLastName(request.getParameter("lastName"));
            }
            if (request.getParameter("nationalCode").equals("")) {
                naturalCustomer.setNationalCode(null);
            } else {
                naturalCustomer.setNationalCode(request.getParameter("nationalCode"));
            }

            naturalCustomers = NaturalCustomerLogic.search(naturalCustomer);
            LoggerUtil.getLogger().info("جستجوبا موفقیت انجام شد.");
            request.setAttribute("naturalCustomers", naturalCustomers);
            getServletConfig().getServletContext().getRequestDispatcher("/natural-customer-search-result.jsp").forward(request, response);

        } catch (DataNotFoundException e) {
            LoggerUtil.getLogger().info("مشتری با این مشخصات یافت نشد!");
            e.getMessage();
        }


    }


}
