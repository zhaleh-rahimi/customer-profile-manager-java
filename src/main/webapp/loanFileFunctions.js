function fetchLoanTypes() {

}
function fetchCustomerInfo() {
    var firstName = document.getElementsByName("firstName");
    var lastName = document.getElementsByName("lastName");
    var table = document.getElementById("customerInfo");
    var rowCount = table.rows.length;
    if (rowCount == 0) {
        addHeader();
    }
    rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
    row.insertCell(1).innerHTML = '<input type="text" name="firstName" value="' + firstName.value + '" readonly>';
    row.insertCell(2).innerHTML = '<input type="text" name="lastName" value="' + lastName.value + '" readonly>';
}

function addHeader() {
    var table = document.getElementById("customerInfo");
    var rowCount = table.rows.length;
    var headerRow = table.insertRow(rowCount);
    var headerCell = document.createElement("TH");
    headerCell.innerHTML = "نام";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "نام خانوادگی";
    headerRow.appendChild(headerCell);

}