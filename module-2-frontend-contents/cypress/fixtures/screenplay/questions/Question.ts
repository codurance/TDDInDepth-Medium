import {Actor} from "../actors/Actor.ts";

export interface Question<T> {
    askedBy(actor: Actor): T;
}

