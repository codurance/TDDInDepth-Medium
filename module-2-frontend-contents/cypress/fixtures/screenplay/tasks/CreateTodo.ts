import {NewTodo} from "../../../../src/whatWouldYouTest/types/NewTodo.ts";
import {Actor} from "../actors/Actor.ts";
import {ClickUsingMouse} from "../abilities/ClickUsingMouse.ts";
import {TypeUsingKeyboard} from "../abilities/TypeUsingKeyboard.ts";
import {TodoPage} from "../../pages/TodoPage.ts";
import {Task} from "./Task.ts";

export class CreateTodo implements Task {
    private newTodo: NewTodo;

    constructor(newTodo: NewTodo) {
        this.newTodo = newTodo;
    }

    performAs(actor: Actor): void {
        const useMouse = actor.abilities.find(ability => ability instanceof ClickUsingMouse);
        const useKeyboard = actor.abilities.find(ability => ability instanceof TypeUsingKeyboard);

        if (!useMouse || !useKeyboard) {
            throw new Error('The actor does not have the ability to use the mouse or keyboard');
        }

        new TodoPage().createTodo(this.newTodo);
    }
}