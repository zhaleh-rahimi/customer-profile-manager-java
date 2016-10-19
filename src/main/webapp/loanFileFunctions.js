function fetchCustomerInfo() {
    var customerId = document.getElementById("customerId").value;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            var customer = JSON.parse(request.response);
            var firstName = customer.firstName;
            var lastName = customer.lastName;
            showCustomerInfo(firstName, lastName);
        }
    };
    request.open("GET", "/LoanFileServlet?action=retrieve-customer&customerId=" + customerId, true);
    request.send();
}

function showCustomerInfo(firstName, lastName) {
    if (lastName != "خطا") {
        document.getElementById("nameHeader").innerHTML = "نام";
        document.getElementById("lastNameHeader").innerHTML = "نام خانوادگی";
    }
    document.getElementById("firstName").innerHTML = firstName.toString();
    document.getElementById("lastName").innerHTML = lastName.toString();

}

function checkCustomerAvailability() {
    var lastName = document.getElementById("lastName");
    if (lastName == "خطا" || lastName == null) {
        document.getElementById("message").innerHTML = "لطفا مشتری مورد نظر خورد را انتخاب کنید.";
    }
    else {
        return true;
    }
}
