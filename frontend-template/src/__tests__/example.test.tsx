import {describe, expect, it, vi} from "vitest";
import {render, screen} from "@testing-library/react";
import {userEvent} from "@testing-library/user-event";

describe("example", () => {
    it("user should be able to click the button", async () => {
        const onClick = vi.fn();
        render(<>
            <button onClick={onClick}>Click me</button>
        </>)

        const button = screen.getByRole("button");
        await userEvent.click(button);

        expect(onClick).toHaveBeenCalled();
    })
})