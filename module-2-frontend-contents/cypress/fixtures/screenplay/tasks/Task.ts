import {Actor} from "../actors/Actor.ts";

export interface Task {
    performAs(actor: Actor): void;
}