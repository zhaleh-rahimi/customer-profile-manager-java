function fetchCustomerInfo() {
    var customerId = document.getElementById("customerId").value;
    var request = new XMLHttpRequest();
    var customer = null;
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            customer = JSON.parse(request.response);
            if (customer != null) {
                var firstName = customer.firstName;
                var lastName = customer.lastName;
                showCustomerInfo(firstName, lastName);
            }
            else {
                showError();
            }
        }
    };
    request.open("GET", "/LoanFileServlet?action=retrieve-customer&customerId=" + customerId, true);
    request.send();
}

function showCustomerInfo(firstName, lastName) {
    document.getElementById("nameHeader").innerHTML = "نام";
    document.getElementById("lastNameHeader").innerHTML = "نام خانوادگی";
    document.getElementById("firstName").innerHTML = firstName;
    document.getElementById("lastName").innerHTML = lastName;
    document.getElementById("message").innerHTML = "";

}
function showError() {
    document.getElementById("nameHeader").innerHTML = "";
    document.getElementById("lastNameHeader").innerHTML = "";
    document.getElementById("firstName").innerHTML = "";
    document.getElementById("lastName").innerHTML = "";
    document.getElementById("message").innerHTML = "مشتری با این شماره وجود ندارد.";
}

function checkCustomerAvailability() {
    var message = document.getElementById("message");
    if (message != null) {
        document.getElementById("message").innerHTML = "لطفا مشتری مورد نظر خورد را انتخاب کنید.";
    }
    else {
        return true;
    }
}
