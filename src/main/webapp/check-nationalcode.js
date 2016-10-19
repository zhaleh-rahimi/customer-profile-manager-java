function checkNationalCode(nationalCode) {
    alert(nationalCode);
    if (nationalCode.length == 10) {
        var c = parseInt(nationalCode.charAt(9));
        var n = parseInt(nationalCode.charAt(0)) * 10 +
            parseInt(nationalCode.charAt(1)) * 9 +
            parseInt(nationalCode.charAt(2)) * 8 +
            parseInt(nationalCode.charAt(3)) * 7 +
            parseInt(nationalCode.charAt(4)) * 6 +
            parseInt(nationalCode.charAt(5)) * 5 +
            parseInt(nationalCode.charAt(6)) * 4 +
            parseInt(nationalCode.charAt(7)) * 3 +
            parseInt(nationalCode.charAt(8)) * 2;
        var r = n - parseInt(n / 11) * 11;
        if ((r == c) || (r == 11 - c)) {
            return true;
        }
        else {
            alert("کد ملی صحیح نمی باشد");
            return false;
        }
    }
    else if (nationalCode.length != 10) {
        alert("کد ملی باید 10 رقم باشد");
        return false;
    }
}
