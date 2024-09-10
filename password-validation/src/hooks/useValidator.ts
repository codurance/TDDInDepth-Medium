import {PasswordValidator} from "../PasswordValidator/PasswordValidator.ts";

export const useValidator = () => {
    const validator = new PasswordValidator();

    return {validator: validator.execute.bind(validator)};
}