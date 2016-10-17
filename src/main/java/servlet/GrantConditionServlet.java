package servlet;

import business_logic.GrantConditionLogic;
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
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
@WebServlet(name = "GrantConditionServlet", urlPatterns = {"/GrantConditionServlet"})
public class GrantConditionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        MessageUtil errorMessageUtil = new MessageUtil();

        String name= request.getParameter("loanTypeName");
        Float interestRate= Float.valueOf(request.getParameter("interestRate"));
        System.out.println("test after retrieving interestRate from previous page!");

        int rowCount = Integer.valueOf(request.getParameter("rowCount"));
        System.out.println("rowCount : "+rowCount);
//        int rowCount=1;
        ArrayList<GrantCondition> grantConditions = new ArrayList<GrantCondition>();

        try {
            for (int i = 1; i <= rowCount; i++) {
                GrantCondition grantCondition = new GrantCondition();
                grantCondition.setName(request.getParameter("grantName" + i));
                grantCondition.setMinDuration(Integer.parseInt(request.getParameter("minDuration" + i)));
                grantCondition.setMaxDuration(Integer.parseInt(request.getParameter("maxDuration" + i)));
                grantCondition.setMinAmount(new BigDecimal(request.getParameter("minAmount" + i)));
                grantCondition.setMaxAmount(new BigDecimal(request.getParameter("maxAmount" + i)));
                System.out.println(grantCondition);
                grantConditions.add(grantCondition);
            }
            LoanType loanType=new LoanType(name,interestRate);

            GrantConditionLogic.insertGrantConditions(loanType,grantConditions);

            MessageUtil.info = "ثبت انجام شد.";
            MessageUtil.header = "عملیات موفق";
            request.setAttribute("error", errorMessageUtil);
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (FieldRequiredException e) {
            MessageUtil.info = "ورود همه فیلدها الزامی است.";
            MessageUtil.header = "عملیات ناموفق";
            request.setAttribute("error", errorMessageUtil);
            getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

}
