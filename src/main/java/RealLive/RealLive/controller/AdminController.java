package RealLive.RealLive.controller;

import RealLive.RealLive.models.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import RealLive.RealLive.service.AdminService;

import java.util.Optional;

/**
 * A {@code RestController} for {@code admin}.
 */
@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService = new AdminService();

    @GetMapping("")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Welcome to admin controller!");
    }

    @PostMapping("")
    public ResponseEntity<Admin> createAdmin(@RequestParam String username) {
        Admin newAdmin = adminService.createAdmin(username);
        return ResponseEntity.ok(newAdmin);
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable String adminId, @RequestParam String username) {
        if (!adminService.updateUsername(adminId, username)) {
            return ResponseEntity.badRequest().build();
        }

        return adminService.selectAdminById(adminId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

//    TODO
//    @GetMapping("/{adminId}/leaderboards")
//    public List<Leaderboard> (@PathVariable String adminId);
}
