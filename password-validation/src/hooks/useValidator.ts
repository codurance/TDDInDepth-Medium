export const useValidator = () => {
    const validator = (password: string): boolean => {
        if (password.length <= 8) {
            return false;
        }

        if (!/[A-Z]/.test(password)) {
            return false;
        }

        if(!/\d/.test(password)) {
            return false;
        }

        if(!/_/.test(password)) {
            return false;
        }

        return true;
    }

    return {validator}
}