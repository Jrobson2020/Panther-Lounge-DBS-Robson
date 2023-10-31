// catalog

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

function clickToHide(hideThis) {
   if (hideThis.classList.contains(showForNow) && !classList.toggle("hide")) {
      switch (hideThis) {
         case "name":
            document.getElementById("itemName").classList.toggle("hide");
            break;
         case "type":
            document.getElementById("itemType").classList.toggle("hide");
            break;
         case "series":
            document.getElementById("itemSeries").classList.toggle("hide");
            break;
         case "shelf":
            document.getElementById("itemShelf").classList.toggle("hide");
            break;
         case "section":
            document.getElementById("itemSection").classList.toggle("hide");
            break;
         case "status":
            document.getElementById("itemStatus").classList.toggle("hide");
            break;
         case "rating":
            document.getElementById("itemRating").classList.toggle("hide");
            break;
         case "club":
            document.getElementById("itemClub").classList.toggle("hide");
            break;
         case "description":
            document.getElementById("itemDescription").classList.toggle("hide");
            break;
         case "other":
            document.getElementById("itemOther").classList.toggle("hide");
            break;
         case "ID":
            document.getElementById("itemID").classList.toggle("hide");
            break;
      }
   }
   else if (hideThis.classList.contains(showForNow) && classList.toggle("hide")) {
      switch (hideThis) {
         case "name":
            document.getElementById("itemName").classList.toggle("show");
            break;
         case "type":
            document.getElementById("itemType").classList.toggle("show");
            break;
         case "series":
            document.getElementById("itemSeries").classList.toggle("show");
            break;
         case "shelf":
            document.getElementById("itemShelf").classList.toggle("show");
            break;
         case "section":
            document.getElementById("itemSection").classList.toggle("show");
            break;
         case "status":
            document.getElementById("itemStatus").classList.toggle("show");
            break;
         case "rating":
            document.getElementById("itemRating").classList.toggle("show");
            break;
         case "club":
            document.getElementById("itemClub").classList.toggle("show");
            break;
         case "description":
            document.getElementById("itemDescription").classList.toggle("show");
            break;
         case "other":
            document.getElementById("itemOther").classList.toggle("show");
            break;
         case "ID":
            document.getElementById("itemID").classList.toggle("show");
            break;
      }
   }
}

// woahhh what's this? automatic date machine? so cool
function twoWeeks(coDate, ciDate) {
   plusTwoWeeks = addDays(document.getElementById(coDate), 14);
   ciDate = plusTwoWeeks;
   return ciDate;
}
