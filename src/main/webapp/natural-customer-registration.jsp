<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <link href=cssfile/styleSheet.css rel=stylesheet>
    <script type="text/javascript" src="/check-nationalcode.js"></script>
    <title>ثبت مشتری حقیقی جدید</title>
</head>
<body>
<div id="wrapper">
    <div class="content">
        <div class="layer">
            <div class="layer-in">
                <br>
                <p>لطفا اطلاعات مشتری را وارد نمایید.</p>
                <br>
                <form action="CreateNaturalCustomer" method="post" onsubmit="checkNationalCode(document.getElementById('nationalCode').value())">
                    <table>
                        <tr>
                            <td> نام</td>
                            <td><input type="text" name="firstName" required></td>
                        </tr>
                        <tr>
                            <td> نام خانوادگی</td>
                            <td><input type="text" name="lastName" required></td>
                        </tr>
                        <tr>
                            <td>نام پدر</td>
                            <td><input type="text" name="fatherName" required></td>
                        </tr>
                        <tr>
                            <td>تاریخ تولد</td>
                            <td><input type="DATE" name="dateOfBirth" required></td>
                        </tr>
                        <tr>
                            <td>کد ملی</td>
                            <td><input type="text" name="nationalCode" id="nationalCode" required>
                            </td>
                        </tr>
                    </table>

                    <input type="submit" class="button" value="ثبت اطلاعات">
                    <a href="../natural-customer-management.jsp" class="form">بازگشت به صفحه قبل</a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>