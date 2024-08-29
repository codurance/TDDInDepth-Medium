import {Ability} from "./Ability.ts";

export class TypeUsingKeyboard implements Ability {
    perform(element: Cypress.Chainable<JQuery>, text: string): void | Promise<void> {
        element.type(text);
    }
}