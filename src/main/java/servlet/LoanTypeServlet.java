package servlet;

import business_logic.LoanTypeLogic;
import business_logic.exceptions.DuplicateInformationException;
import business_logic.exceptions.FieldRequiredException;
import data_access.entity.GrantCondition;
import data_access.entity.LoanType;
import util.MessageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
@WebServlet(name = "LoanTypeServlet", urlPatterns = {"/LoanType"})
public class LoanTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        MessageUtil errorMessageUtil = new MessageUtil();
        LoanType loanType = new LoanType();
        try {
            loanType.setLoanTypeName(request.getParameter("loanTypeName"));
            loanType.setInterestRate(Float.valueOf(request.getParameter("interestRate")));
            request.setAttribute("loanType", loanType);
            getServletConfig().getServletContext().getRequestDispatcher("/grant-condition.jsp").forward(request, response);
        } catch (FieldRequiredException e) {
            MessageUtil.info = "ورود همه فیلدها الزامی است.";
            MessageUtil.header = "عملیات ناموفق";
            request.setAttribute("error", errorMessageUtil);
            getServletConfig().getServletContext().getRequestDispatcher("/grant-condition.jsp").forward(request, response);
        }


    }


}
