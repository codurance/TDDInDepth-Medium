import {PasswordValidatorTemplate} from "./PasswordValidatorTemplate.ts";

export class StandardPasswordValidator extends PasswordValidatorTemplate {
    protected hasLowerCase(password: string) {
        return /[a-z]/.test(password);
    }
    protected hasSpecialCharacter(password: string) {
        return /_/.test(password);
    }
    protected hasNumber(password: string) {
        return /\d/.test(password);
    }
    protected hasUpperCase(password: string) {
        return /[A-Z]/.test(password);
    }
    protected hasRequiredLength(password: string) {
        return password.length > 8;
    }
}