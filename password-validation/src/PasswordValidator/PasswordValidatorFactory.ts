import {PasswordValidation} from "./PasswordValidation.ts";
import {StandardPasswordValidator} from "./StandardPasswordValidator.ts";

export class PasswordValidatorFactory {
    public static create(passwordValidation: PasswordValidation) {
        switch (passwordValidation) {
            case PasswordValidation.STANDARD_VALIDATION:
                return new StandardPasswordValidator();
            default:
                throw new Error("Invalid password validation");
        }
    }
}