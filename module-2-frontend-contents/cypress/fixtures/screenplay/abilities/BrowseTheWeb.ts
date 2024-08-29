import {Ability} from "./Ability.ts";

export class BrowseTheWeb implements Ability {
    perform(url: string): void | Promise<void> {
        cy.visit(url)
    }
}