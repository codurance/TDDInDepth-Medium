export class PasswordValidator {
    public execute(password: string) {
        if (!this.hasRequiredLength(password)) {
            return false;
        }

        if (!/[A-Z]/.test(password)) {
            return false;
        }

        if (!/\d/.test(password)) {
            return false;
        }

        if (!/_/.test(password)) {
            return false;
        }

        if (!/[a-z]/.test(password)) {
            return false;
        }

        return true;
    }

    private hasRequiredLength(password: string) {
        return password.length > 8;
    }
}