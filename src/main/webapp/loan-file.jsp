<%@ page import="data_access.entity.LoanType" %>
<%@ page import="data_access.entity.NaturalCustomer" %>
<%@ page import="java.util.List" %>
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
                <%
                    NaturalCustomer naturalCustomer = (NaturalCustomer) request.getAttribute("naturalCustomer");
                %>
                <br>
                <table class="header">
                    <tr>
                        <th>شماره مشتری</th>
                        <td><input type="text" name="customerId"></td>
                        <a href="LoanFile?action=retrieve-customer" onclick="fetchCustomerInfo()">بازیابی</a>
                        <%--<input type="hidden" name="firstName" value="<%=naturalCustomer.getFirstName()%>">
                        <input type="hidden" name="lastName" value="<%=naturalCustomer.getLastName()%>">--%>
                    </tr>
                </table>
                <br>
                <hr>
                <br>
                <table class="header" id="customerInfo">

                </table>
                <br>
                <hr>
                <br>
                <h3>نوع تسهیلات مورد نظر خود را انتخاب فرمایید:</h3>
                <br>


                <form action="SearchNaturalCustomer?action=check-conditions-and-submit" method="post">
                    <input type="hidden" name="action" value="fetch-loan-types">
                    <% List<LoanType> loanTypes = (List<LoanType>) request.getAttribute("loanTypes"); %>
                    <div class="search-box">
                        <select name="loanTypes">
                            <% for (LoanType loanType : loanTypes) { %>
                            <option value="<%= loanType.getLoanTypeId()%>"><%= loanType.getLoanTypeName()%>
                            </option>
                            <%}%>
                        </select>
                    </div>
                    <br>
                    <br>
                    <input type="text" name="duration" value="مدت قرارداد مورد نظر خود را وارد نمایید">
                    <br>
                    <input type="text" name="duration" value="مبلغ قرارداد مورد نظر خود را وارد نمایید">
                    <input type="submit" class="button" value="ثبت پرونده">
                    <a href="../natural-customer-management.jsp" class="form">بازگشت به صفحه قبل</a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
