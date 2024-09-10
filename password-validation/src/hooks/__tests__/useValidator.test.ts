import {describe, expect, it} from "vitest";
import {useValidator} from "../useValidator.ts";
import {PasswordValidation} from "../../PasswordValidator/PasswordValidation.ts";

describe("useValidator", () => {
    it("should return true for a valid password", () => {
        const {validator} = useValidator();

        expect(validator("Password123_")).toBe(true);
    })


    it.each([
        ["Pass123_"],
        ["Pass12_"],
    ])("should return false for a password with 8 or less characters", (password: string) => {
        const {validator} = useValidator();

        expect(validator(password)).toBe(false);
    })

    it("should return false for a password with no capital letter", () => {
        const {validator} = useValidator();

        expect(validator("password123_")).toBe(false);
    })

    it("should return false for a password with no number", () => {
        const {validator} = useValidator();

        expect(validator("Password_")).toBe(false);
    })

    it("should return false for a password with no underscore", () => {
        const {validator} = useValidator();

        expect(validator("Password123")).toBe(false);
    })

    it("should return false for a password with no lowercase letter", () => {
        const {validator} = useValidator();

        expect(validator("PASSWORD123_")).toBe(false);
    })

    describe("with short validation", () => {
        it.each([
            [true, "Passw0r"],
            [false, "passw0r"],
            [false, "PASSW0R"],
            [false, "Passwor"],
            [false, "Passw0"]
        ])("should validate password with short validation", (expected: boolean, password: string) => {
            const {validator} = useValidator(PasswordValidation.SHORT_VALIDATION);

            expect(validator(password)).toBe(expected);
        })
    })
})