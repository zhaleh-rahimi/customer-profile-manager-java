<%@ page import="data_access.entity.LoanType" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <link href=cssfile/styleSheet.css rel=stylesheet>
    <script type="text/javascript" src="/dynamic-table-script.js"></script>
    <title>شروط اعطا</title>
</head>
<body>
<div id="wrapper">
    <div class="content">
        <div class="layer">
            <div class="layer-in">
                <%
                    LoanType loanType = (LoanType) request.getAttribute("loanType");
                %>
                <br>
                <table class="header">

                    <tr>
                        <th>نام تسهیلات</th>
                        <th>نرخ سود تسهیلات</th>
                    </tr>
                    <tr>
                        <td><%=loanType.getLoanTypeName()%>
                        </td>
                        <td><%=loanType.getInterestRate()%>
                        </td>
                    </tr>
                </table>
                <br>
                <br>
                <h3>لطفا شروط اعطا را وارد نمایید:</h3>
                <br>
                <table>
                    <tr>
                        <td>نام</td>
                        <td><input type="text" id="grantName"></td>
                    </tr>
                    <tr>
                        <td>حداقل مدت قرارداد</td>
                        <td><input type="text" id="minDuration"></td>
                    </tr>
                    <tr>
                        <td>حداکثر مدت قرارداد</td>
                        <td><input type="text" id="maxDuration"></td>
                    </tr>
                    <tr>
                        <td>حداقل مبلغ قرارداد</td>
                        <td><input type="text" id="minAmount"></td>
                    </tr>
                    <tr>
                        <td>حداکثر مبلغ قرارداد</td>
                        <td><input type="text" id="maxAmount"></td>
                    </tr>
                </table>
                <input class="button" type="submit" value="اضافه کردن" onclick="addToTable()">
                <br>
                <br>
                <form action="GrantConditionServlet" method="get">
                    <input type="hidden" name="loanTypeName" value="<%=loanType.getLoanTypeName()%>">
                    <input type="hidden" name="interestRate" value="<%=loanType.getInterestRate()%>">
                    <table class="grant-table" id="grantConditionsTable">
                    </table>
                    <br>
                <input type="submit" class="button" value="ثبت اطلاعات">
                <a href="../loan-type.jsp" class="form">بازگشت به صفحه قبل</a>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
