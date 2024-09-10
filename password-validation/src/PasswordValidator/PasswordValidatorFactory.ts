import {PasswordValidation} from "./PasswordValidation.ts";
import {StandardPasswordValidator} from "./StandardPasswordValidator.ts";
import {ShortPasswordValidator} from "./ShortPasswordValidator.ts";

export class PasswordValidatorFactory {
    public static create(passwordValidation: PasswordValidation) {
        switch (passwordValidation) {
            case PasswordValidation.STANDARD_VALIDATION:
                return new StandardPasswordValidator();
            case PasswordValidation.SHORT_VALIDATION:
                return new ShortPasswordValidator();
            default:
                throw new Error("Invalid password validation");
        }
    }
}