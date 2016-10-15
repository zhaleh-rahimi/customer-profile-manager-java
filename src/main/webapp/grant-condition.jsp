<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <link href=cssfile/styleSheet.css rel=stylesheet>
    <title>شروط اعطا</title>
</head>
<body>
<div id="wrapper">
    <div class="content">
        <div class="layer">
            <div class="layer-in">
                <br>
                <p>لطفا شروط اعطا را وارد نمایید.</p>
                <br>
                <form action="GrantCondition" method="post" onsubmit="">
                    <table>
                        <tr>
                            <td> نام</td>
                            <td><input type="text" name="name"></td>
                            <button type="button" onclick="addToTable()">افزودن</button>
                        </tr>
                        <tr>
                            <td> حداقل مدت قرارداد</td>
                            <td><input type="NUMBER" name="minDuration"></td>
                            <button type="button" onclick="addToTable()">افزودن</button>
                        </tr>
                        <tr>
                            <td>حداکثر مدت قرارداد</td>
                            <td><input type="NUMBER" name="maxDuration"></td>
                            <button type="button" onclick="addToTable()">افزودن</button>
                        </tr>
                        <tr>
                            <td>حداقل مبلغ قرارداد</td>
                            <td><input type="NUMBER" name="minAmount"></td>
                            <button type="button" onclick="addToTable()">افزودن</button>
                        </tr>
                        <tr>
                            <td>حداکثر مبلغ قرارداد</td>
                            <td><input type="NUMBER" name="maxAmount">
                            </td>
                            <button type="button" onclick="addToTable()">افزودن</button>
                        </tr>
                    </table>
                    <p></p>
                    <table id="grant-condition-table">

                    </table>


                    <input type="submit" class="button" value="ثبت اطلاعات">
                    <a href="../loan-type.jsp" class="form">بازگشت به صفحه قبل</a>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
