package service;

import models.Admin;
import models.Leaderboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Handles logic for {@code Admin}.
 */
public class AdminService {

    private final List<Admin> admins = new ArrayList<>(); // placeholder

    /**
     * Creates an admin.
     * @param username Username for the newly-created admin
     */
    public Admin createAdmin(String username) {
        Admin newAdmin = new Admin();
        newAdmin.setUserName(username);
        admins.add(newAdmin);
        return newAdmin;
    }

    /**
     * Updates an admin's username.
     * @param adminId The id for the admin
     * @param username The new username for the admin
     * @return {@code true} if username is successfully updated, otherwise {@code false}
     */
    public boolean updateUsername(String adminId, String username) {
        Optional<Admin> optionalAdmin = selectAdminById(adminId);

        if (optionalAdmin.isEmpty()) {
            return false;
        }

        Admin admin = optionalAdmin.get();
        admin.setUserName(username);
        return true;
    }

    /**
     * Returns leaderboards owned by {@code Admin}.
     * @return List of leaderboards
     */
    public List<Leaderboard> getLeaderboards() {
        return List.of();
    }

    /**
     * Selects admin by id.
     * @param adminId The admin id; should not be null.
     * @return {@code Optional} which may contain an {@code admin} if present
     */
    public Optional<Admin> selectAdminById(String adminId) {
        assert adminId != null;

        return admins.stream()
                .filter(admin -> adminId.equals(admin.getId()))
                .findFirst();
    }
}
