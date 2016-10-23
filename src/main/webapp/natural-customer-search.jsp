<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <link href=cssfile/styleSheet.css rel=stylesheet>
    <title>جستجوی مشتری حقیقی</title>
</head>
<body>
<div id="wrapper">
    <div class="content">
        <div class="layer">
            <div class="layer-in">
                <br>
                <br>
                <p>جستجوی مشتری :</p>
                <div class="search-box">
                    <form action="SearchNaturalCustomer" method="post" >
                        <table>
                            <tr>
                                <td> نام</td>
                                <td><input type="text" name="firstName"></td>
                            </tr>
                            <tr>
                                <td> نام خانوادگی</td>
                                <td><input type="text" name="lastName"></td>
                            </tr>
                            <tr>
                                <td>شماره مشتری</td>
                                <td><input type="text" name="customerId"></td>
                            </tr>
                            <tr>
                                <td>کد ملی</td>
                                <td><input type="text" name="nationalCode" id="nationalCode">
                                </td>
                            </tr>
                        </table>
                        <br>
                        <br>

                        <br>
                        <input type="submit" class="button" value="جستجو">
                        <a href="../natural-customer-management.jsp" class="form">بازگشت به صفحه قبل</a>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>