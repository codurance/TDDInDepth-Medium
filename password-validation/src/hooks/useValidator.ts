export const useValidator = () => {
    const validator = (password: string): boolean => {
        return true;
    }

    return {validator}
}