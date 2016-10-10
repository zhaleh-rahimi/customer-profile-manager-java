<%@ page import="data_access.entity.NaturalCustomer" %>
<%@ page import="util.Message" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <link href=cssfile/styleSheet.css rel=stylesheet>
    <title>نتیجه به روز رسانی مشتری حقیقی </title>
</head>
<body>
<div id="wrapper">
    <div class="content">
        <div class="layer">
            <div class="layer-in">
                <br>
                <p> نتیجه به روز رسانی مشتری حقیقی:</p>

                <%
                    NaturalCustomer naturalCustomer = (NaturalCustomer) request.getAttribute("naturalCustomer");
                    if (naturalCustomer != null) {
                %>
                <p style="color: chartreuse">موفقیت آمیز</p>
                <br>
                <table>
                    <tr>
                        <th>نام</th>
                        <th>نام خانوادگی</th>
                        <th>نام پدر</th>
                        <th>تاریخ تولد</th>
                        <th>شماره ملی</th>
                        <th>شماره مشتری
                        </th>
                    </tr>
                    <tbody>
                    <tr>

                        <td>
                            <%=naturalCustomer.getFirstName()%>
                        </td>
                        <td>
                            <%=naturalCustomer.getLastName()%>
                        </td>
                        <td>
                            <%=naturalCustomer.getFatherName()%>
                        </td>

                        <td>
                            <%=naturalCustomer.getDateOfBirth() %>
                        </td>
                        <td>
                            <%=naturalCustomer.getNationalCode() %>
                        </td>
                        <td>
                            <%=naturalCustomer.getCustomerId() %>
                        </td>

                    </tr>
                    </tbody>
                </table>
                <%
                } else {
                    Message errorMessage = (Message) request.getAttribute("error");
                %>
                <h2 style="color: #b80000"><%=errorMessage.getHeader()%>
                </h2>
                <h3 style="color: #b80000"><%=errorMessage.getInfo()%>
                </h3>
                <%}%>
                <a href="../customer-type-selection.html" class=form>بازگشت به خانه</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
</title>
</head>
<body>

</body>
</html>