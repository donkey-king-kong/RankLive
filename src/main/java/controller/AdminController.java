package controller;

import models.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService;

import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService = new AdminService();

    @PostMapping("")
    public ResponseEntity<Admin> createAdmin(@RequestParam String username) {
        Admin newAdmin = adminService.createAdmin(username);
        return ResponseEntity.ok(newAdmin);
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable String adminId, @RequestParam String username) {
        Optional<Admin> optionalAdmin = adminService.selectAdminById(adminId);

        if (optionalAdmin.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        if (!adminService.updateUsername(adminId, username)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(optionalAdmin.get());
    }

//    TODO
//    @GetMapping("/{adminId}/leaderboards")
//    public List<Leaderboard> (@PathVariable String adminId);
}
