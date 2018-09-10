
//customer search by id
function searchCustomer() {
    var xmlhttp = new XMLHttpRequest();
    var cmbItemname = document.forms["search"]["cmbItemname"].value;
    var url = "search-items?cmbItemname=" + cmbItemname ;
//            "&name=" + name + "&address=" + address
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var response = xmlhttp.responseText;
            var fields = response.split('+');
            var name = fields[2];
            var address = fields[1];
            var test = fields[0];
            document.getElementById("txtUnit").value = name;
            document.getElementById("txtUnitprice").value = address;
            document.getElementById("txtItemcode").value = test;
        }
    };
    try {
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
    } catch (e) {
        alert("unable to connect to server");
    }

}

document.getElementById("btnAddTable").disabled = true;

$("#txtQty").keyup(function () {

    // document.getElementById("btnAddTable").disabled = true;

    var unitprice = document.getElementById("txtUnitprice").value;
    var qty = document.getElementById("txtQty").value;

    var amount = +unitprice * +qty;

    $("#txtTotalprice").val(amount);

    document.getElementById("btnAddTable").disabled = false;


});


$("#btnAddTable").click(function () {

    var table = document.getElementById("tblEstimate");

    var itemname = document.getElementById("cmbItemname").value;
    var unit = document.getElementById("txtUnit").value;
    var unitprice = document.getElementById("txtUnitprice").value;
    var qty = document.getElementById("txtQty").value;

    var amount = +unitprice * +qty;

    var row = table.insertRow(-1);

    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);

    if (table.rows.length === 2) {
        cell1.innerHTML = itemname;
        cell2.innerHTML = unit;
        cell3.innerHTML = unitprice;
        cell4.innerHTML = qty;
        cell5.innerHTML = amount;
        cell6.innerHTML = "<i class=\"fa fa-trash-o\" aria-hidden=\"true\" id=\"remove\"></i>";

        document.getElementById("txtTotal").value = amount;

    } else {
        var sQty = 0;
        var sAmount = 0;
        for (var i = 1; i < table.rows.length; i++) {
            // console.log("sada : " + table.rows[i].cells[0].innerHTML);
            // console.log("sdsd : " + itemCode);
            if ((table.rows[i].cells[0].innerHTML) === itemname) {
                // console.log("working table : "+i);
                sQty = table.rows[i].cells[3].innerHTML;
                sAmount = table.rows[i].cells[4].innerHTML;
                table.deleteRow(i);
            }
        }
        cell1.innerHTML = itemname;
        cell2.innerHTML = unit;
        cell3.innerHTML = unitprice;
        cell4.innerHTML = +qty + +sQty;
        cell5.innerHTML = +amount + +sAmount;
        cell6.innerHTML = "<i class=\"fa fa-trash-o\" aria-hidden=\"true\" id=\"remove\"></i>";
        //
        var am = document.getElementById("txtTotal").value;
        document.getElementById("txtTotal").value = +am + +amount;
    }

    $("#remove").click(function(){
        var row = $(this).parents("tr");
        row.fadeOut(500);
        setTimeout(function(){
            $(row).remove();
        },600);

    });
});


$("#btnPrint").click(function () {
    window.print();
});

