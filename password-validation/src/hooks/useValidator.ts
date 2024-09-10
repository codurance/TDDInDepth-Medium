import {PasswordValidation} from "../PasswordValidator/PasswordValidation.ts";
import {PasswordValidatorFactory} from "../PasswordValidator/PasswordValidatorFactory.ts";

export const useValidator = (passwordValidation: PasswordValidation = PasswordValidation.VALIDATION_1) => {
    const validator = PasswordValidatorFactory.create(passwordValidation);

    return {validator: validator.execute.bind(validator)};
}