import {PasswordValidatorTemplate} from "./PasswordValidatorTemplate.ts";

export class ShortPasswordValidator extends PasswordValidatorTemplate {
    protected hasLowerCase(password: string): boolean {
        return /[a-z]/.test(password);
    }

    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    protected hasSpecialCharacter(_: string): boolean {
        return true;
    }

    protected hasNumber(password: string): boolean {
        return /\d/.test(password);
    }

    protected hasUpperCase(password: string): boolean {
        return /[A-Z]/.test(password);
    }

    protected hasRequiredLength(password: string): boolean {
        return password.length > 6;
    }
}