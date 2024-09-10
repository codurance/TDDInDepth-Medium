import {describe, expect, it, vi} from "vitest";
import {render, screen} from "@testing-library/react";
import {userEvent} from "@testing-library/user-event";
import {PasswordValidationForm} from "../components/PasswordValidationForm.tsx";

describe("PasswordValidationForm", () => {
    it("user should be able to submit a valid password", async () => {
        const user = userEvent.setup();

        const onValidate = vi.fn();
        render(<PasswordValidationForm onValidate={onValidate}/>)

        const passwordField = screen.getByLabelText("What's the password you want to validate?");
        await user.type(passwordField, "Password123_");

        const validateButton = screen.getByRole("button", {name: "Validate"});
        await userEvent.click(validateButton);

        expect(onValidate).toHaveBeenCalled();
    })
})