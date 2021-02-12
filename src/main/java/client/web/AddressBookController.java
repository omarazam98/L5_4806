package client.web;

import client.AddressBookRepo;
import client.addressbook.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressBookController {
    @Autowired
    private AddressBookRepo repo;

    @GetMapping("/address/create")
    public String createAddressBook(Model model) {
        AddressBook book = new AddressBook();
        model.addAttribute("address", book);
        return "index";
    }
}
