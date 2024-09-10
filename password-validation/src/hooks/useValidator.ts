export const useValidator = () => {
    const validator = (password: string): boolean => {
        if (password.length === 8) {
            return false;
        }

        return true;
    }

    return {validator}
}