<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <link href=cssfile/styleSheet.css rel=stylesheet>
    <title>نوع تسهیلات</title>
</head>
<body>
<div id="wrapper">
    <div class="content">
        <div class="layer">
            <div class="layer-in">
                <br>
                <p>لطفا نوع تسهیلات را وارد کنید:</p>
                <br>
                <form action="LoanType" method="post" onsubmit="">
                    <table>
                        <tr>
                            <td> نام نوع تسهیلات</td>
                            <td><input type="text" name="loanType"></td>
                        </tr>
                        <tr>
                            <td> نرخ سود</td>
                            <td><input type="text" name="interestRate"></td>
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
