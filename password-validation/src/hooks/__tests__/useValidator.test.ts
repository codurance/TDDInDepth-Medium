import {it, describe, expect} from "vitest";
import {useValidator} from "../useValidator.ts";

describe("useValidator", () => {
    it("should return true for a valid password", () => {
        const {validator} = useValidator();

        expect(validator("Password123_")).toBe(true);
    })


    it.each([
        ["Pass123_"],
    ])("should return false for a password with 8 or less characters", (password: string) => {
        const {validator} = useValidator();

        expect(validator(password)).toBe(false);
    })
})