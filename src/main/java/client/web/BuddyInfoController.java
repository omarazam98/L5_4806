package client.web;

import client.BuddyInfoRepo;
import client.addressbook.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BuddyInfoController {
    @Autowired
    private BuddyInfoRepo repo;

    @GetMapping("/")
    public String home(Model model) {
        Iterable i = repo.findAll();
        List<BuddyInfo> result = new ArrayList<BuddyInfo>();
        i.forEach((x) -> {
            result.add((BuddyInfo) x);
        });
        model.addAttribute("buddies", result.toArray(new BuddyInfo[0]));
        model.addAttribute("buddy", new BuddyInfo());
        return "index";
    }

    @PostMapping("/buddy/add")
    public String addBuddy(@ModelAttribute BuddyInfo buddy, Model model) {
        model.addAttribute("buddy", buddy);
        repo.save(buddy);
        model.addAttribute("id", buddy.getId());
        model.addAttribute("name", buddy.getName());
        model.addAttribute("address", buddy.getAddress());
        model.addAttribute("birthday", buddy.getBirthday());
        model.addAttribute("company", buddy.getCompany());
        model.addAttribute("phonenumber", buddy.getPhoneNumber());
        return "show_buddy";
    }

    @GetMapping("/buddy/show")
    public String getBuddy(@RequestParam(name = "id") Long id, Model model) {
        if (repo.existsById(id)) {
            Optional<BuddyInfo> info = repo.findById(id);
            BuddyInfo buddy = info.get();
            model.addAttribute("id", buddy.getId());
            model.addAttribute("name", buddy.getName());
            model.addAttribute("address", buddy.getAddress());
            model.addAttribute("birthday", buddy.getBirthday());
            model.addAttribute("company", buddy.getCompany());
            model.addAttribute("phonenumber", buddy.getPhoneNumber());
        }
        return "show_buddy";
    }

    @GetMapping("/buddy/remove")
    public String removeBuddy(@RequestParam(name = "id") Long id, Model model) {
        Optional<BuddyInfo> info = repo.findById(id);
        BuddyInfo buddy = info.get();
        model.addAttribute("name", buddy.getName());
        model.addAttribute("address", buddy.getAddress());
        model.addAttribute("birthday", buddy.getBirthday());
        model.addAttribute("company", buddy.getCompany());
        model.addAttribute("phonenumber", buddy.getPhoneNumber());
        repo.delete(buddy);
        return "remove_buddy";
    }
}
