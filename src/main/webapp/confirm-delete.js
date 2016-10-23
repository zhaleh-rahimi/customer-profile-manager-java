function confirmDelete(delUrl) {
    var request = new XMLHttpRequest();
    if (confirm("آیا حذف مشتری را تایید می کنید؟")) {
        request.onreadystatechange = function () {
            if (request.readyState == 4 && request.status == 200) {
                var message = JSON.parse(request.response);
                var info1 = message.INFO;
                var header1 = message.HEADER;
                document.getElementById("header").innerHTML = header1;
                document.getElementById("info").innerHTML = info1;

            }
        }
        ;
        request.open("GET", delUrl, true);
        request.send();
    }
}

