import {it, describe, expect} from "vitest";
import {useValidator} from "../useValidator.ts";

describe("useValidator", () => {
    it("should return true for a valid password", () => {
        const {validator} = useValidator();

        expect(validator("Password123_")).toBe(true);
    })
})