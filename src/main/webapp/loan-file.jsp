<%@ page import="data_access.entity.LoanType" %>
<%@ page import="java.util.ArrayList" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <link href=cssfile/styleSheet.css rel=stylesheet>
    <script type="text/javascript" src="/loanFileFunctions.js"></script>
    <title>تشکیل پرونده تسهیلاتی</title>
</head>
<body>
<div id="wrapper">
    <div class="content">
        <div class="layer">
            <div class="layer-in">
                <br>
                <form action="LoanFileServlet" method="get" onsubmit="checkCustomerAvailability()">
                    <input type="text" name="action" value="create-loan-file" hidden>
                    <table >
                        <tr>
                            <td>شماره مشتری:</td>
                            <td><input type="text" name="customerId" id="customerId"
                                       value="<%=request.getAttribute("customerId")%>" required></td>
                            <td>
                                <input class="button1" value="بازیابی" onclick="fetchCustomerInfo()" READONLY>
                            </td>
                        </tr>
                    </table>
                    <table id="customerInfo">
                        <tr><th id="nameHeader"></th><th id="lastNameHeader"></th></tr>
                        <tr><td id="firstName"></td><td id="lastName"></td></tr>
                    </table>
                    <h3 id="message" style="color: #b80000"></h3>
                    <br>
                    <hr>
                    <br>
                    <%
                        ArrayList<LoanType> loanTypes = (ArrayList<LoanType>) request.getAttribute("loanTypes"); %>
                    <h3>نوع تسهیلات مورد نظر خود را انتخاب فرمایید:</h3>
                    <br>
                    <select name="loanTypesList" class="dropdown">
                        <div class="dropdown-content">
                            <% for (LoanType loanType : loanTypes) { %>
                            <option
                                    value="<%= loanType.getLoanTypeId()%>"><%= loanType.getLoanTypeName()%>
                            </option>
                            <%}%>
                        </div>
                    </select>
                    <br>
                    <table>
                        <br>
                        <tr>
                            <td>مدت قرارداد</td>
                            <td><input type="text" name="duration" required></td>
                        </tr>
                        <tr>
                            <td>مبلغ قرارداد</td>
                            <td><input type="text" name="amount" required></td>
                        </tr>
                    </table>
                    <input type="submit" class="button" value="ثبت پرونده" >
                    <a href="../natural-customer-management.jsp" class="form">بازگشت به صفحه قبل</a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
