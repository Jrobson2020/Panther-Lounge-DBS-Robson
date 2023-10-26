// cannot remember what this was for
function search(str) {
   if (str.length == 0) {
      document.getElementById("searchBar").innerHTML = "";
      return;
   }
}

function liveSearch() {
   var input = document.getElementById("searchBar");
   var filter = input.ariaValueMax.toUpperCase();
   var table = document.getElementById("catalog");
   var tr = table.getElementsByTagName("tr");
   for (var length = 0; length < tr.length; length++) {
      var td = tr[length].getElementsByTagName("td")[0];
      if (td) {
         txtValue = td.textContent || td.innerText;
         if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[length].style.display = "";
         }
         else {
            tr[length].style.display = "none"
         }
      }
   }
}
