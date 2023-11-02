// live search in searchbar
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

// show/hide content
function clickToHide(targetColumn) {
   if (document.getElementById(targetColumn).style.visibility === "visible") {
      document.getElementById(targetColumn).style.visibility = "hidden"
      document.getElementById(targetColumn).display = "none"
   }
   else {
      document.getElementById(targetColumn).style.visibility = "visible";
      document.getElementById(targetColumn).display = "block"
   }
}

// woahhh what's this? automatic date machine? so cool
function twoWeeks(coDate, ciDate) {
   plusTwoWeeks = addDays(document.getElementById(coDate), 14);
   ciDate = plusTwoWeeks;
   return ciDate;
}

// copy id number
function copyThis(number) {
   navigator.clipboard.writeText(number);
}
