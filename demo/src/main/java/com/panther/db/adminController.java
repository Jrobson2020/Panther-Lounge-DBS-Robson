package com.panther.db;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.panther.details.itemDetails;

import org.springframework.web.bind.annotation.SessionAttributes; 

@Controller()
@RequestMapping("/admin")
public class adminController {
   
   @GetMapping("")
   public String baseGet(Model model) {
      return "adminBase";
   }
   
   @GetMapping("/add")
   public String get(Model model) {
      model.addAttribute("item", new itemDetails());
      return "adding";
   }
   
   @PostMapping("/add")
   public String post(@ModelAttribute("item") itemDetails item, Model model) {
      JDBC sql = new JDBC();
      if(sql.addItem(item))
         model.addAttribute("message", "item added successfully");
      else
         model.addAttribute("message", "Did not add item");
      return "status";
   }
}