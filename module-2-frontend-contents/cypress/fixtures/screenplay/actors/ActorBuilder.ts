import {Actor} from "./Actor.ts";
import {Ability} from "../abilities/Ability.ts";

export class ActorBuilder {
    private name: string;
    private abilities: Ability[] = [];

    protected constructor(name: string) {
        this.name = name;
    }

    public static anActorCalled(name: string): ActorBuilder {
        return new ActorBuilder(name);
    }

    public whoCan(...abilities: Ability[]): Actor {
        this.abilities.push(...abilities);

        return new Actor(this.name, this.abilities);
    }
}