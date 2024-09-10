export abstract class PasswordValidatorTemplate {
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

    protected abstract hasLowerCase(password: string): boolean;

    protected abstract hasSpecialCharacter(password: string): boolean;

    protected abstract hasNumber(password: string): boolean;

    protected abstract hasUpperCase(password: string): boolean;

    protected abstract hasRequiredLength(password: string): boolean;
}