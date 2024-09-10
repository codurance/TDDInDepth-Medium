import {it, describe, expect} from "vitest";
import {useValidator} from "../useValidator.ts";

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
})