function checkNationalCode(nationalCode) {
    //var nationalCode = document.getElementById("nationalCode");
    if (nationalCode.length == 10) {
        c = parseInt(nationalCode.charAt(9));
        n = parseInt(nationalCode.charAt(0)) * 10 +
            parseInt(nationalCode.charAt(1)) * 9 +
            parseInt(nationalCode.charAt(2)) * 8 +
            parseInt(nationalCode.charAt(3)) * 7 +
            parseInt(nationalCode.charAt(4)) * 6 +
            parseInt(nationalCode.charAt(5)) * 5 +
            parseInt(nationalCode.charAt(6)) * 4 +
            parseInt(nationalCode.charAt(7)) * 3 +
            parseInt(nationalCode.charAt(8)) * 2;
        r = n - parseInt(n / 11) * 11;
        if ((r == 0 && r == c) || (r == 1 && c == 1) || (r > 1 && c == 11 - r) || (r > 1 && c == r)) {
            return true;
        }
        else {
            alert("کد ملی صحیح نمی باشد");
            objcode.focus();
            return false;
        }
    }
    else {
        alert("کد ملی باید 10 رقم باشد");
        return false;
    }
}
