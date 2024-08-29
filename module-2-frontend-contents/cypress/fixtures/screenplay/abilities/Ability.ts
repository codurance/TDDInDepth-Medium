export interface Ability {
    perform(...args: unknown[]): void | Promise<void>;
}

