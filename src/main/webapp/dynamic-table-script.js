
function addToTable() {


    var grantName = document.getElementById("grantName");
    var minDuration = document.getElementById("minDuration");
    var maxDuration = document.getElementById("maxDuration");
    var minAmount = document.getElementById("minAmount");
    var maxAmount = document.getElementById("maxAmount");
    var table = document.getElementById("grantConditionsTable");
    var rowCount = table.rows.length;
    if (rowCount == 0) {
        addHeader();
    }
    if (grantName.value != "" && minAmount.value != "" && maxAmount.value != "" && minDuration.value != "" && maxDuration != "") {
        rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        row.insertCell(0).innerHTML = rowCount.toString();
        row.insertCell(1).innerHTML = '<input type="text" name="grantName' + rowCount + '" value="' + grantName.value + '" readonly>';
        row.insertCell(2).innerHTML = '<input type="text" name="minDuration' + rowCount + '" value="' + minDuration.value + '" readonly>';
        row.insertCell(3).innerHTML = '<input type="text" name="maxDuration' + rowCount + '" value="' + maxDuration.value + '" readonly>';
        row.insertCell(4).innerHTML = '<input type="text" name="minAmount' + rowCount + '" value="' + minAmount.value + '" readonly>';
        row.insertCell(5).innerHTML = '<input type="text" name="maxAmount' + rowCount + '" value="' + maxAmount.value + '" readonly>';
        row.insertCell(6).innerHTML = '<button class="button" onClick="deleteRow(this)">حذف</button>';

    }
    
    
    }
function rowCounter() {
    var table = document.getElementById("grantConditionsTable");
    var rowCount = table.rows.length-1;
    document.getElementById("rowCount").value=rowCount;
    }


function addHeader() {
    var table = document.getElementById("grantConditionsTable");
    var rowCount = table.rows.length;
    var headerRow = table.insertRow(rowCount);
    var headerCell = document.createElement("TH");
    headerCell.innerHTML = "ردیف";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "نام شرط";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "حداقل مدت قرارداد";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "حداکثر مدت قرارداد";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "حداقل مبلغ قرارداد";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "حداکثر مبلغ قرارداد";
    headerRow.appendChild(headerCell);
    headerCell = document.createElement("TH");
    headerCell.innerHTML = "عملیات";
    headerRow.appendChild(headerCell);
}

function deleteRow(obj) {
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("grantConditionsTable");
    table.deleteRow(index);
    var rowCount = table.rows.length;
    if (rowCount == 1) {
        table.innerHTML = "";
    } else {
        for (var i = 1; i < rowCount; i++) {
            table.rows[i].cells[0].innerHTML = i.toString();
        }
    }
}

