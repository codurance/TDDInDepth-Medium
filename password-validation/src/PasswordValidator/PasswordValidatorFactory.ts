import {PasswordValidation} from "./PasswordValidation.ts";
import {PasswordValidator} from "./PasswordValidator.ts";

export class PasswordValidatorFactory {
    public static create(passwordValidation: PasswordValidation) {
        switch (passwordValidation) {
            case PasswordValidation.VALIDATION_1:
                return new PasswordValidator();
            default:
                throw new Error("Invalid password validation");
        }
    }
}