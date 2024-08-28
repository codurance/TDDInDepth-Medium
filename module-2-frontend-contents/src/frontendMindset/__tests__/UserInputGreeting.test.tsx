import {render, screen} from "@testing-library/react";
import UserInputGreeting from "../UserInputGreeting.tsx";
import {userEvent} from "@testing-library/user-event";
import {describe, it, expect} from "vitest";

describe("UserInputGreeting", () => {
    it("should greet the user", async () => {
        render(<UserInputGreeting/>);
        const nameField = screen.getByLabelText("What's your name?")

        await userEvent.type(nameField, "Ben")

        const greeting = screen.getByText("Hello, Ben!");
        expect(greeting).toBeVisible();
    })
})