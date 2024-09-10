export class PasswordValidator {
    public execute(password: string) {
        if (!this.hasRequiredLength(password)) {
            return false;
        }

        if (!this.hasUpperCase(password)) {
            return false;
        }

        if (!this.hasNumber(password)) {
            return false;
        }

        if (!this.hasSpecialCharacter(password)) {
            return false;
        }

        return this.hasLowerCase(password);
    }

    private hasLowerCase(password: string) {
        return /[a-z]/.test(password);
    }

    private hasSpecialCharacter(password: string) {
        return /_/.test(password);
    }

    private hasNumber(password: string) {
        return /\d/.test(password);
    }

    private hasUpperCase(password: string) {
        return /[A-Z]/.test(password);
    }

    private hasRequiredLength(password: string) {
        return password.length > 8;
    }
}