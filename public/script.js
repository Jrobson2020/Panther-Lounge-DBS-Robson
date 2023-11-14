// sending query from homepage to catalog searchbar
function fillFromIndex(userSearch) {
   document.getElementById("searchBar").innerHTML = window
}

// live search in searchbar
function liveSearch() {
   var input = document.getElementById("searchBar");
   var searchUpCase = input.ariaValueMax.toUpperCase();
   var table = document.getElementById("catalog");
   var tr = table.getElementsByTagName("tr");
   for (var row = 0; row < tr.length; row++) {
      var td = tr[row].getElementsByTagName("td")[0];
      if (td) {
         var txtValue = td.textContent || td.innerText;
         if (txtValue.toUpperCase().indexOf(searchUpCase) > -1) {
            tr[row].style.display = "";
         }
         else {
            tr[row].style.display = "none"
         }
      }
   }
}

// show/hide checkboxes
function boxDispl() {
   if (document.getElementById("boxes").style.display === "none") {
      document.getElementById("boxes").style.display = "block";
   }
   else {
      document.getElementById("boxes").style.display = "none";
   }
}

// show/hide column
function columnVis(element) {
   if (document.getElementById(element).style.visibility === "visible") {
      document.getElementById(element).style.visibility = "collapse";
   }
   else {
      document.getElementById(element).style.visibility = "visible";
   }
}

// copy id number
function copyThis(number) {
   navigator.clipboard.writeText(number);
}

// sends user and item ID to checkout form

// gets today's date

// determines date of expected check-in
function twoWeeks(coDate) {
   document.getElementById("ciDate").innerHTML = addDays(document.getElementById(coDate), 14);
   // figure out how to read school calendar in case it hits an invalid date
}
