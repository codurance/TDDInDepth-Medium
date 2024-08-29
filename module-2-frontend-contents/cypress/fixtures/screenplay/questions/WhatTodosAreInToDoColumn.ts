import {Actor} from "../actors/Actor.ts";
import {TodoPage} from "../../pages/TodoPage.ts";
import {Question} from "./Question.ts";

export class WhatTodosAreInToDoColumn implements Question<Cypress.Chainable<JQuery<HTMLElement>>> {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    askedBy(_actor: Actor) {
        return new TodoPage().getTodosInToDoColumn();
    }
}