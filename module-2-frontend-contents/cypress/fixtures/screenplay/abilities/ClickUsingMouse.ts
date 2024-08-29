import {Ability} from "./Ability.ts";

export class ClickUsingMouse implements Ability {
    perform(element: Cypress.Chainable<JQuery>): void | Promise<void> {
        element.click();
    }
}