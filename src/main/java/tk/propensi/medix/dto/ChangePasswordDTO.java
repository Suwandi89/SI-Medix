package tk.propensi.medix.dto;

public class ChangePasswordDTO {
    public String oldPassword;
    public String newPassword;
    public String confirmPassword;

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
