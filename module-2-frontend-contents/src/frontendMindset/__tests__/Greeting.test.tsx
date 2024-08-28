import {describe, it, expect} from "vitest";
import {render, screen} from "@testing-library/react";
import Greeting from "../Greeting.tsx";

describe("Greeting", () => {
    it("should greet the user", () => {
        render(<Greeting name={"Ben"}/>);

        const renderedGreeting = screen.queryByText("Hello, Ben!");

        expect(renderedGreeting).toBeVisible();
    })
})