import {Actor} from "../actors/Actor.ts";
import {BrowseTheWeb} from "../abilities/BrowseTheWeb.ts";
import {Task} from "./Task.ts";

export class VisitTodoPage implements Task {
    performAs(actor: Actor): void {
        const ability = actor.abilities.find(ability => ability instanceof BrowseTheWeb);

        if (!ability) {
            throw new Error('The actor does not have the ability to browse the web');
        }

        ability.perform("/todos");
    }
}